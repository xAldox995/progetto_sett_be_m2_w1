package aldovalzani.progetto_sett_be_m2_w1.runners;

import aldovalzani.progetto_sett_be_m2_w1.entities.Postazione;
import aldovalzani.progetto_sett_be_m2_w1.entities.Prenotazione;
import aldovalzani.progetto_sett_be_m2_w1.entities.Utente;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotAvailableException;
import aldovalzani.progetto_sett_be_m2_w1.services.PostazioneService;
import aldovalzani.progetto_sett_be_m2_w1.services.PrenotazioneService;
import aldovalzani.progetto_sett_be_m2_w1.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;

    @Override
    public void run(String... args) throws Exception {

        //PRENDO TUTTI GLI UTENTI
        Utente utFound1 = utenteService.findUtenteById(52);
        Utente utFound2 = utenteService.findUtenteById(53);

        //PRENDO TUTTE LE POSTAZIONI

        Postazione postFound1 = postazioneService.findPostazioneById(1);
        Postazione postFound2 = postazioneService.findPostazioneById(2);
        Postazione postFound3 = postazioneService.findPostazioneById(3);
        Postazione postFound4 = postazioneService.findPostazioneById(4);

        //Ora posso creare tutte le Prenotazioni
        Prenotazione prenotazione1 = new Prenotazione(utFound1, LocalDate.now().plusDays(2), List.of(postFound1));
        Prenotazione prenotazione2 = new Prenotazione(utFound1, LocalDate.now().plusDays(2), List.of(postFound2));


        try {
            prenotazioneService.savePrenotazione(prenotazione2);
        } catch (NotAvailableException ex) {
            log.error(ex.getMessage());
        }


    }
}
