package classes.models;

import classes.enumerations.CategoriaEnum;
import classes.enumerations.RegioneEnum;
import jakarta.persistence.*;


import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;
    @Column(nullable = false)
    private String nome;

    private String descrizione;
    @Column(nullable = false)
    private LocalDateTime dataOra;
    @Column(nullable = false)
    private List<CategoriaEnum> categorieEvento;
    @Column(nullable = false)
    private RegioneEnum luogoEvento;
    private Foto fotoEvento;
    @Column(nullable = false)
    private boolean privato;
    @Column(nullable = false)
    private String indirizzo;
    private Integer postiTotali;
    @Column(nullable = false)
    private Utente utenteOrganizzatore;

    @ManyToMany(mappedBy = "eventi")
    private List<Utente> utenti = new ArrayList<>();

    public Evento(Integer idEvento, String nome, String descrizione, LocalDateTime dataOra,
                  List<CategoriaEnum> categorieEvento, RegioneEnum luogoEvento, Foto fotoEvento,
                  boolean privato, String indirizzo, Integer postiTotali, Utente utenteOrganizzatore) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataOra = dataOra;
        this.categorieEvento = categorieEvento;
        this.luogoEvento = luogoEvento;
        this.fotoEvento = fotoEvento;
        this.privato = privato;
        this.indirizzo = indirizzo;
        this.postiTotali = postiTotali;
        this.utenteOrganizzatore = utenteOrganizzatore;
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
        this.indirizzo = indirizzo;
    }

    public Integer getPostiTotali() {
        return postiTotali;
    }

    public void setPostiTotali(Integer postiTotali) {
        this.postiTotali = postiTotali;
    }

    public RegioneEnum getLuogo() {
        return luogoEvento;
    }

    public void setLuogo(RegioneEnum luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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
