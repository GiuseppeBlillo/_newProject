package classes.Models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Utente idUtente;
    @Column(nullable = false)
    private Evento idEvento;
    private String campoTestuale;
    @Column(nullable = false)
    private Integer rating;
    private List<Foto> foto;

    public Recensione(Integer id, Utente idUtente, Evento idEvento, String campoTestuale, Integer rating) {
        this.id = id;
        this.idUtente = idUtente;
        this.idEvento = idEvento;
        this.campoTestuale = campoTestuale;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public Utente getIdUtenteRecensione() {
        return idUtente;
    }

    public void setIdUtenteRecensione(Utente idUtenteRecensione) {
        this.idUtente = idUtente;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampoTestuale() {
        return campoTestuale;
    }

    public void setCampoTestuale(String campoTestuale) {
        this.campoTestuale = campoTestuale;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Foto> getFoto() {
        return foto;
    }

    public void setFoto(List<Foto> foto) {
        this.foto = foto;
    }
}
