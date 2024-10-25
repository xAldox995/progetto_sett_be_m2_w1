package aldovalzani.progetto_sett_be_m2_w1.repositories;

import aldovalzani.progetto_sett_be_m2_w1.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {
}
