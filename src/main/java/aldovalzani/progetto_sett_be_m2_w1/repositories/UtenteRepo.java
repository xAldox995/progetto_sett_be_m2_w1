package aldovalzani.progetto_sett_be_m2_w1.repositories;

import aldovalzani.progetto_sett_be_m2_w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepo extends JpaRepository<Utente, Long> {
}
