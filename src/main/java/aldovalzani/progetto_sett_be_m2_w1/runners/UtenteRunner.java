package aldovalzani.progetto_sett_be_m2_w1.runners;

import aldovalzani.progetto_sett_be_m2_w1.entities.Utente;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UtenteRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        Utente utente1 = new Utente("mario@rossi.com", "Mario Rossi", "Ambrogio");
        Utente utente2 = new Utente("aldo@baglio.com", "Aldo Baglio", "Wrath");
        /*
        utenteService.saveUtente(utente1);
        utenteService.saveUtente(utente2);
        */

        log.info("Elenco Utenti: ");
        utenteService.findAllUtenti().forEach(utente -> log.info(utente.toString()));

        try {
            Utente utenteFound = utenteService.findUtenteById(53);
            log.info("Questo è l'Utente che cercavi: " + utenteFound.toString());
        } catch (NotFoundException ex) {
            log.error(ex.getMessage());
        }
    }
}
