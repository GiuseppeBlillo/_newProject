package classes;

public class Categoria {
    private Integer id;
    private String genere;
    private boolean perMaggiorenni;

    public Categoria(Integer id, String genere) {
        this.id = id;
        this.genere = genere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public boolean isPerMaggiorenni() {
        return perMaggiorenni;
    }

    public void setPerMaggiorenni(boolean perMaggiorenni) {
        this.perMaggiorenni = perMaggiorenni;
    }
}
