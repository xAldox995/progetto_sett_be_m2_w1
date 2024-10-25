package aldovalzani.progetto_sett_be_m2_w1.services;

import aldovalzani.progetto_sett_be_m2_w1.entities.Prenotazione;
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

    public List<Prenotazione> findPrenotazioneByDataAndUtente(LocalDate data, long utenteId) {
        return prenotazioniRepo.findByDataEUtenteId(data, utenteId);
    }
}
