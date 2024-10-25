package aldovalzani.progetto_sett_be_m2_w1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utente {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String user_name;
    private String nome;
    private String email;

    public Utente(String email, String nome, String user_name) {
        this.email = email;
        this.nome = nome;
        this.user_name = user_name;
    }
}
