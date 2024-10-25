package aldovalzani.progetto_sett_be_m2_w1.services;

import aldovalzani.progetto_sett_be_m2_w1.entities.Utente;
import aldovalzani.progetto_sett_be_m2_w1.exceptions.NotFoundException;
import aldovalzani.progetto_sett_be_m2_w1.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepo utenteRepo;

    public Utente saveUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    public Utente findUtenteById(long utenteId) {
        return utenteRepo.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
    }

    public List<Utente> findAllUtenti() {
        return utenteRepo.findAll();
    }

}
