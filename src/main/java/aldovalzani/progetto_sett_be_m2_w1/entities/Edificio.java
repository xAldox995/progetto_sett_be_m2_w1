package aldovalzani.progetto_sett_be_m2_w1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "edifici")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Edificio {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String indirizzo;
    private String citta;

    public Edificio(String citta, String indirizzo, String nome) {
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.nome = nome;
    }
}
