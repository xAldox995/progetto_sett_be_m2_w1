package aldovalzani.progetto_sett_be_m2_w1.services;

import aldovalzani.progetto_sett_be_m2_w1.entities.Prenotazione;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotAvailableException;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.repositories.PrenotazioniRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioniRepo prenotazioniRepo;

    public Prenotazione findPrenotazioneById(long prenotazioneId) {
        return prenotazioniRepo.findById(prenotazioneId).orElseThrow(() -> new NotFoundException(prenotazioneId));
    }

    public List<Prenotazione> findAllPrenotazioni() {
        return prenotazioniRepo.findAll();
    }

    public List<Prenotazione> findPrenotazioneByDataAndUtenteId(LocalDate data, long utenteId) {
        return prenotazioniRepo.findByDataEUtenteId(data, utenteId);
    }

    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        //SCOMPONGO I DATI DELLA PRENOTAZIONE PER FARE I VARI CONTROLLI
        long postazioneId = prenotazione.getPostazioni().get(0).getId();
        long utenteId = prenotazione.getUtente().getId();
        LocalDate data_prenotazione = prenotazione.getData_prenotazione();

        //CONTROLLO SE L'UTENTE HA GIA PRENOTATO LA STESSA POSTAZIONE NELLA STASSA DATA
        List<Prenotazione> prenotazioniUtente = prenotazioniRepo.findByUtenteIdEPostazioneIdEData(utenteId, postazioneId, data_prenotazione);
        if (!prenotazioniUtente.isEmpty()) {
            throw new NotAvailableException("L' utente ha già prenotato questa postazione");
        }

        //CONTROLLO CHE LA POSTAZIONE SIA DISPONIBILE O SIA GIA PRENOTATA DA UN ALTRO UTENTE

        List<Prenotazione> prenotazionePostazione = prenotazioniRepo.findByPoStazioneEData(postazioneId, data_prenotazione);
        if (!prenotazionePostazione.isEmpty()) {
            throw new NotAvailableException("La postazione è già prenotata per la data selezionata");
        }

        return prenotazioniRepo.save(prenotazione);
    }
}
