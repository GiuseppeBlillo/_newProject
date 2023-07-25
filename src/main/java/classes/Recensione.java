package classes;

import java.util.List;

public class Recensione {

    private Integer id;
    private Evento evento;
    private String campoTestuale;
    private Integer rating;
    private List<Foto> foto;

    public Recensione(Integer id, Evento evento, Integer rating) {
        this.id = id;
        this.evento = evento;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
