package classes;

public class Partecipazione {
    private Integer id;
    private Utente idUtente;
    private Evento idEvento;

    public Partecipazione(Integer id, Utente idUtente, Evento idEvento) {
        this.id = id;
        this.idUtente = idUtente;
        this.idEvento = idEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
