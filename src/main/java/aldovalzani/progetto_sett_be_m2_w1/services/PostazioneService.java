package aldovalzani.progetto_sett_be_m2_w1.services;

import aldovalzani.progetto_sett_be_m2_w1.entities.Postazione;
import aldovalzani.progetto_sett_be_m2_w1.entities.enums.TipoPostazione;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.repositories.PostazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepo postazioneRepo;

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepo.save(postazione);
    }

    public Postazione findPostazioneById(long postazioneId) {
        return postazioneRepo.findById(postazioneId).orElseThrow(() -> new NotFoundException(postazioneId));
    }

    public List<Postazione> findAllEdifici() {
        return postazioneRepo.findAll();
    }

    public List<Postazione> findPostazioniByTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepo.findByTipoECitta(tipo, citta);
    }
}
