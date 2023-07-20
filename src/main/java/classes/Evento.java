package classes;

public class Evento {
    private String nome;
    private String descrizione;
    private Integer dataEvento;
    private Integer oraEvento;
    private boolean privato;
    private String Indirizzo;
    private Integer postiTotali;
    private Integer postiDisponibili;
    private Integer postiOccupati;

    public Evento(String nome, String descrizione, Integer dataEvento, Integer oraEvento, boolean privato, String indirizzo, Integer postiTotali, Integer postiDisponibili) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataEvento = dataEvento;
        this.oraEvento = oraEvento;
        this.privato = privato;
        Indirizzo = indirizzo;
        this.postiTotali = postiTotali;
        this.postiDisponibili = postiDisponibili;
    }

    public Integer getOraEvento() {
        return oraEvento;
    }

    public void setOraEvento(Integer oraEvento) {
        this.oraEvento = oraEvento;
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

    public Integer getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Integer dataEvento) {
        this.dataEvento = dataEvento;
    }

    public boolean isPrivato() {
        return privato;
    }

    public void setPrivato(boolean privato) {
        this.privato = privato;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
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
}
