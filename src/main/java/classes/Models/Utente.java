package classes.Models;

import classes.Enumerations.CategoriaEnum;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
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
    @Column(unique = true,nullable = false)
    private String indirizzoMailUtente;
    @Column(unique = true,nullable = false)
    private Integer numeroTelefonoUtente;
    private List<CategoriaEnum> interessiUtente;
    @ManyToMany
    @JoinTable(name ="Partecipazione",
    joinColumns = {@JoinColumn(name = "idUtente")},
    inverseJoinColumns = { @JoinColumn(name = "idEvento")})
    private List<Evento> eventi = new ArrayList<>();


    public Utente(Integer idUtente, String nomeUtente, String cognomeUtente, Integer etaUtente, String indirizzoMailUtente) {
        this.idUtente = idUtente;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.etaUtente = etaUtente;
        this.indirizzoMailUtente = indirizzoMailUtente;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer id) {
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

    public List<CategoriaEnum> getInteressiUtente() {
        return interessiUtente;
    }

    public void setInteressiUtente(List<CategoriaEnum> interessiUtente) {
        this.interessiUtente = interessiUtente;
    }
}





