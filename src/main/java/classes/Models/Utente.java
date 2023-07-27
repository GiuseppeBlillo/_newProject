package classes.Models;

import classes.Enumerations.CategoriaEnum;


import java.util.List;

public class Utente {
    private Integer id;
    private String nomeUtente;
    private String cognomeUtente;
    private Integer etaUtente;
    private String genereUtente;
    private String indirizzoMailUtente;
    private Integer numeroTelefonoUtente;
    private List<CategoriaEnum> interessiUtente;


    public Utente(Integer id, String nomeUtente, String cognomeUtente, Integer etaUtente, String indirizzoMailUtente) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.etaUtente = etaUtente;
        this.indirizzoMailUtente = indirizzoMailUtente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGenereUtente() {
        return genereUtente;
    }

    public void setGenereUtente(String genereUtente) {
        this.genereUtente = genereUtente;
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





