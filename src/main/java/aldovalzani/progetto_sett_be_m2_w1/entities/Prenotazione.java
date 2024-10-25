package aldovalzani.progetto_sett_be_m2_w1.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private LocalDate data_prenotazione;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToMany
    @JoinTable(
            name = "prenotazione_postazione",
            joinColumns = @JoinColumn(name = "prenotazione_id"),
            inverseJoinColumns = @JoinColumn(name = "postazione_id")
    )
    private List<Postazione> postazioni;

    public Prenotazione(Utente utente, LocalDate data_prenotazione, List<Postazione> postazioni) {
        this.utente = utente;
        this.data_prenotazione = data_prenotazione;
        this.postazioni = postazioni != null ? new ArrayList<>(postazioni) : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "data_prenotazione=" + data_prenotazione +
                ", id=" + id +
                ", utente=" + utente +
                ", postazioni=" + postazioni +
                '}';
    }
}
