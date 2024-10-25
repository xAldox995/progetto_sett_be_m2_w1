package aldovalzani.progetto_sett_be_m2_w1.repositories;

import aldovalzani.progetto_sett_be_m2_w1.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioniRepo extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT p FROM Prenotazione p WHERE p.data_prenotazione = :data AND p.utente.id = :utenteId")
    List<Prenotazione> findByDataEUtenteId(LocalDate data, long utenteId);
}
