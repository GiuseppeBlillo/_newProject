package classes.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="RECENSIONE")
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecensione;
    @Column(nullable = false)
    private Utente idUtente;
    @Column(nullable = false)
    private Evento idEvento;
    @Column
    private String campoTestuale;
    @Column(nullable = false)
    private Integer rating;
    @Column
    private List<Foto> foto;
    @OneToMany(mappedBy = "recensione")
    private List<Foto> fotos= new ArrayList<>();

    public Recensione(){}

    public Integer getIdRecensione() {
        return idRecensione;
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

    public void setIdRecensione(Integer idRecensione) {
        this.idRecensione = idRecensione;
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
