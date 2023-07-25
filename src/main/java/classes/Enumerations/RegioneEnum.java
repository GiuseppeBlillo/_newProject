package classes.Enumerations;


public enum RegioneEnum {
    VALLEDAOSTA ("AOSTA"),
    LIGURIA ("GENOVA"),
    PIEMONTE("TORINO"),
    LOMBARDIA("MILANO"),
    TRENTINOALTOADIGE("TRENTO"),
    FRIULIVENEZIAGIULIA("TRIESTE"),
    VENETO("VENEZIA"),
    EMILIAROMAGNA("BOLOGNA"),
    TOSCANA("FIRENZE"),
    ABRUZZO("AQUILA"),
    LAZIO("ROMA"),
    MARCHE("ANCONA"),
    UMBRIA("PERUGIA"),
    MOLISE("CAMPOBASSO"),
    CAMPANIA("NAPOLI"),
    PUGLIA("BARI"),
    BASILICATA("POTENZA"),
    CALABRIA("CATANZARO"),
    SICILIA("PALERMO"),
    SARDEGNA("CAGLIARI");

    private Integer id;
    private String citta;

    RegioneEnum(String citta) {
        this.citta = citta;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
