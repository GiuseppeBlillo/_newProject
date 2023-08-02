package classes.models;

import jakarta.persistence.*;

@Entity
@Table
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartecipazione;
    @Column(nullable = false)
    private Utente idUtente;
    @Column(nullable = false)
    private Evento idEvento;

    public Partecipazione(Integer idPartecipazione, Utente idUtente, Evento idEvento) {
        this.idPartecipazione = idPartecipazione;
        this.idUtente = idUtente;
        this.idEvento = idEvento;
    }

    public Integer getIdPartecipazione() {
        return idPartecipazione;
    }

    public void setIdPartecipazione(Integer id) {
        this.idPartecipazione = idPartecipazione;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }
}
