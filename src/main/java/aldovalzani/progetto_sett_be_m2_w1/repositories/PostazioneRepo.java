package aldovalzani.progetto_sett_be_m2_w1.repositories;

import aldovalzani.progetto_sett_be_m2_w1.entities.Postazione;
import aldovalzani.progetto_sett_be_m2_w1.entities.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, Long> {
    @Query("SELECT p FROM Postazione p WHERE p.tipo_postazione = :tipo AND p.edificio.citta = :citta")
    List<Postazione> findByTipoECitta(TipoPostazione tipo, String citta);


}
