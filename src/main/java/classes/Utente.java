package classes;

import classes.Enumerations.CategoriaEnum;


import java.util.List;

public class Utente {
    private Integer id;
    private String nome;
    private String cognome;
    private Integer eta;
    private String genere;
    private String indirizzoMail;
    private Integer numeroTelefono;
    private List<CategoriaEnum> interessi;

    public Utente(Integer id, String nome, String cognome, Integer eta, String genere, String indirizzoMail, Integer numeroTelefono, List<CategoriaEnum> interessi) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.genere = genere;
        this.indirizzoMail = indirizzoMail;
        this.numeroTelefono = numeroTelefono;
        this.interessi = interessi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getIndirizzoMail() {
        return indirizzoMail;
    }

    public void setIndirizzoMail(String indirizzoMail) {
        this.indirizzoMail = indirizzoMail;
    }

    public Integer getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Integer numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<CategoriaEnum> getInteressi() {
        return interessi;
    }

    public void setInteressi(List<CategoriaEnum> interessi) {
        this.interessi = interessi;
    }
}
