package classes.models;

import java.util.List;

public class Recensione {

    private Integer id;
    private Utente idUtenteRecensione;
    private Evento idEvento;
    private String campoTestuale;
    private Integer rating;
    private List<Foto> foto;

    public Recensione(Integer id, Utente idUtenteRecensione, Evento idEvento, String campoTestuale, Integer rating) {
        this.id = id;
        this.idUtenteRecensione = idUtenteRecensione;
        this.idEvento = idEvento;
        this.campoTestuale = campoTestuale;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public Utente getIdUtenteRecensione() {
        return idUtenteRecensione;
    }

    public void setIdUtenteRecensione(Utente idUtenteRecensione) {
        this.idUtenteRecensione = idUtenteRecensione;
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
