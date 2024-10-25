package aldovalzani.progetto_sett_be_m2_w1.entities;

import aldovalzani.progetto_sett_be_m2_w1.entities.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo_postazione;
    private int num_max_persone;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @ManyToMany(mappedBy = "postazioni")
    private List<Prenotazione> prenotazionei;

    public Postazione(String descrizione, Edificio edificio, int num_max_persone, TipoPostazione tipo_postazione) {
        this.descrizione = descrizione;
        this.edificio = edificio;
        this.num_max_persone = num_max_persone;
        this.tipo_postazione = tipo_postazione;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "descrizione='" + descrizione + '\'' +
                ", edificio=" + edificio +
                ", id=" + id +
                ", num_max_persone=" + num_max_persone +
                ", tipo_postazione=" + tipo_postazione +
                '}';
    }
}
