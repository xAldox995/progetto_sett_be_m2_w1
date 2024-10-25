package aldovalzani.progetto_sett_be_m2_w1.runners;

import aldovalzani.progetto_sett_be_m2_w1.entities.Edificio;
import aldovalzani.progetto_sett_be_m2_w1.entities.Postazione;
import aldovalzani.progetto_sett_be_m2_w1.entities.enums.TipoPostazione;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.services.EdificioService;
import aldovalzani.progetto_sett_be_m2_w1.services.PostazioneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostazioneRunner implements CommandLineRunner {
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        Edificio edFound1 = edificioService.findEdificioById(152);
        Edificio edFound2 = edificioService.findEdificioById(153);

        Postazione postazione1 = new Postazione("Postazione con vista", edFound1, 1, TipoPostazione.PRIVATO);
        Postazione postazione2 = new Postazione("Postazione spaziosa e nel verde", edFound1, 10, TipoPostazione.OPENSPACE);
        Postazione postazione3 = new Postazione("Postazione con tavoli condivisi", edFound2, 30, TipoPostazione.SALA_RIUNIONI);
        Postazione postazione4 = new Postazione("Postazione ben isolata", edFound2, 1, TipoPostazione.PRIVATO);
/*
        postazioneService.savePostazione(postazione1);
        postazioneService.savePostazione(postazione2);
        postazioneService.savePostazione(postazione3);
        postazioneService.savePostazione(postazione4);

 */

        log.info("Elenco postazioni: ");
        postazioneService.findAllPostazioni().forEach(postazione -> log.info(postazione.toString()));

        try {
            Postazione postazioneFound = postazioneService.findPostazioneById(100);
            log.info("Questo è la postazione che cercavi: " + postazioneFound.toString());
        } catch (NotFoundException ex) {
            log.error(ex.getMessage());
        }

    }
}
