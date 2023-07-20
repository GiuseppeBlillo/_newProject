package classes;

public class Citta {
    private Integer id;
    private String nome;
    private String provincia;
    private String regione;
    private Integer cap;

    public Citta(Integer id, String nome, String provincia, String regione, Integer cap) {
        this.id = id;
        this.nome = nome;
        this.provincia = provincia;
        this.regione = regione;
        this.cap = cap;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }
}
