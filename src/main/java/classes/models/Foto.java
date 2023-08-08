package classes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="FOTO")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String url;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idRecensione", nullable = false)
    private Recensione recensione;

    public Foto(Integer id, String url, Recensione recensione) {
        this.id = id;
        this.url = url;
        this.recensione = recensione;
    }

    public Foto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
