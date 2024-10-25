package aldovalzani.progetto_sett_be_m2_w1.runners;

import aldovalzani.progetto_sett_be_m2_w1.entities.Edificio;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.services.EdificioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EdificiRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        /*Edificio edificio1 = new Edificio("Milano", "Via Roma 1", "Sede Centrale");
        Edificio edificio2 = new Edificio("Valenzano", "Via Bari 1", "Sede Secondaria");
        edificioService.saveEdificio(edificio1);
        edificioService.saveEdificio(edificio2);*/

        log.info("Edifici Inseriti: ");
        edificioService.findAllEdifici().forEach(edificio -> log.info(edificio.toString()));


        try {
            Edificio edificioFound = edificioService.findEdificioById(102);
            log.info(edificioFound.toString());
        } catch (NotFoundException ex) {
            log.error(ex.getMessage());
        }


    }
}
