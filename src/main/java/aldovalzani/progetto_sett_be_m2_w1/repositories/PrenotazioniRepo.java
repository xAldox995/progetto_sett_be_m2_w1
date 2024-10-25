package aldovalzani.progetto_sett_be_m2_w1.repositories;

import aldovalzani.progetto_sett_be_m2_w1.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioniRepo extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT p FROM Prenotazione p WHERE p.data_prenotazione = :data AND p.utente.id = :utenteId")
    List<Prenotazione> findByDataEUtenteId(LocalDate data, long utenteId);

    @Query("SELECT p FROM Postazione p JOIN p.postazioni pos WHERE pos.id =:postazioneId AND p.data = :data")
    List<Prenotazione> findByPoStazioneEData(long postazioneId, LocalDate data);

    @Query("SELECT p FROM Prenotazione p WHERE p.utente.id = :utenteId and p.data = :data AND :postazioneId IN (SELECT pos.id FROM p.postazioni pos)")
    List<Prenotazione> findByUtenteIdEPostazioneIdEData(long utenteId, long postazioneId, LocalDate data);
}
