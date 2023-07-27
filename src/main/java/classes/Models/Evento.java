package classes.Models;

import classes.Enumerations.CategoriaEnum;
import classes.Enumerations.RegioneEnum;


import java.time.LocalDateTime;

import java.util.List;

public class Evento {
    private Integer id;
    private String nome;
    private String descrizione;
    private LocalDateTime dataOra;
    private Utente utenteOrganizzatore;
    private List<CategoriaEnum> categorieEvento;
    private RegioneEnum luogoEvento;
    private Foto fotoEvento;
    private boolean privato;
    private String indirizzo;
    private Integer postiTotali;
    private Integer postiDisponibili;
    private Integer postiOccupati;

    public Evento(Integer id, String nome, String descrizione, LocalDateTime dataOra, Utente utenteOrganizzatore,
                  List<CategoriaEnum> categorieEvento, RegioneEnum luogoEvento, Foto fotoEvento, boolean privato,
                  String indirizzo, Integer postiTotali, Integer postiDisponibili, Integer postiOccupati) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataOra = dataOra;
        this.utenteOrganizzatore = utenteOrganizzatore;
        this.categorieEvento = categorieEvento;
        this.luogoEvento = luogoEvento;
        this.fotoEvento = fotoEvento;
        this.privato = privato;
        this.indirizzo = indirizzo;
        this.postiTotali = postiTotali;
        this.postiDisponibili = postiDisponibili;
        this.postiOccupati = postiOccupati;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isPrivato() {
        return privato;
    }

    public void setPrivato(boolean privato) {
        this.privato = privato;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        indirizzo = indirizzo;
    }

    public Integer getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(Integer postiTotali) {
        this.postiTotali = postiTotali;
    }

    public Integer getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(Integer postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public Integer getPostiOccupati() {
        return postiOccupati;
    }

    public void setPostiOccupati(Integer postiOccupati) {
        this.postiOccupati = postiOccupati;
    }

    public RegioneEnum getLuogo() {
        return luogoEvento;
    }

    public void setLuogo(RegioneEnum luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getUtenteOrganizzatore() {
        return utenteOrganizzatore;
    }

    public void setUtenteOrganizzatore(Utente utenteOrganizzatore) {
        this.utenteOrganizzatore = utenteOrganizzatore;
    }

    public List<CategoriaEnum> getCategorieEvento() {
        return categorieEvento;
    }

    public void setCategorieEvento(List<CategoriaEnum> categorieEvento) {
        this.categorieEvento = categorieEvento;
    }

    public RegioneEnum getLuogoEvento() {
        return luogoEvento;
    }

    public void setLuogoEvento(RegioneEnum luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public Foto getFotoEvento() {
        return fotoEvento;
    }

    public void setFotoEvento(Foto fotoEvento) {
        this.fotoEvento = fotoEvento;
    }
}
