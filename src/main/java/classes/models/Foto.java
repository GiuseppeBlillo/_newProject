package classes.models;

import jakarta.persistence.*;

@Entity
@Table(name="FOTO")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String url;
    @ManyToOne
    @JoinColumn(name="idRecensione", nullable = false)
    private Recensione recensione;

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
