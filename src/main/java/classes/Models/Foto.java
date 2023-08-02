package classes.Models;

public class Foto {

    private Integer id;
    private String url;
    private Integer dimensioneFoto;

    public Foto(Integer id, String url, Integer dimensioneFoto) {
        this.id = id;
        this.url = url;
        this.dimensioneFoto = dimensioneFoto;
    }

    public Integer getDimensioneFoto() {
        return dimensioneFoto;
    }

    public void setDimensioneFoto(Integer dimensioneFoto) {
        this.dimensioneFoto = dimensioneFoto;
    }

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
