package aldovalzani.progetto_sett_be_m2_w1.services;

import aldovalzani.progetto_sett_be_m2_w1.entities.Edificio;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepo edificioRepo;

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepo.save(edificio);
    }

    public Edificio findEdificioById(long edificioId) {
        return edificioRepo.findById(edificioId).orElseThrow(() -> new NotFoundException(edificioId));
    }

    public List<Edificio> findAllEdifici() {
        return edificioRepo.findAll();
    }


}
