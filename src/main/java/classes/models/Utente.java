package classes.models;

import classes.enumerations.CategoriaEnum;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name ="UTENTE")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtente;
    @Column(nullable = false)
    private String nomeUtente;
    @Column(nullable = false)
    private String cognomeUtente;
    @Column(nullable = false)
    private Integer etaUtente;
    private List<CategoriaEnum> categorieEvento;
    @Column(nullable = false,unique = true)
    private String indirizzoMailUtente;
    @Column(nullable = false,unique = true)
    private Integer numeroTelefonoUtente;
    @Column
    private String urlFotoUtente;

    @ManyToMany
    @JoinTable(name = "Partecipazione",
    joinColumns = {@JoinColumn(name = "idUtente")},
    inverseJoinColumns = {@JoinColumn(name = "idEvento")})
    private List<Evento>eventi = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Recensione",
            joinColumns = {@JoinColumn(name = "idUtente")},
            inverseJoinColumns = {@JoinColumn(name = "idEvento")})
    private List<Evento>eventiRecensiti = new ArrayList<>();


    public Utente(Integer idUtente, String nomeUtente, String cognomeUtente, Integer etaUtente, String indirizzoMailUtente, String urlFotoUtente) {
        this.idUtente = idUtente;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.etaUtente = etaUtente;
        this.indirizzoMailUtente = indirizzoMailUtente;
        this.urlFotoUtente = urlFotoUtente;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public Integer getEtaUtente() {
        return etaUtente;
    }

    public void setEtaUtente(Integer etaUtente) {
        this.etaUtente = etaUtente;
    }

    public List<CategoriaEnum> getCategorieEvento() {
        return categorieEvento;
    }

    public void setCategorieEvento(List<CategoriaEnum> categorieEvento) {
        this.categorieEvento = categorieEvento;
    }

    public String getIndirizzoMailUtente() {
        return indirizzoMailUtente;
    }

    public void setIndirizzoMailUtente(String indirizzoMailUtente) {
        this.indirizzoMailUtente = indirizzoMailUtente;
    }

    public Integer getNumeroTelefonoUtente() {
        return numeroTelefonoUtente;
    }


    public void setNumeroTelefonoUtente(Integer numeroTelefonoUtente) {
        this.numeroTelefonoUtente = numeroTelefonoUtente;
    }
    public String getUrlFotoUtente() {
        return urlFotoUtente;
    }

    public void setUrlFotoUtente(String urlFotoUtente) {
        this.urlFotoUtente = urlFotoUtente;
    }
}





