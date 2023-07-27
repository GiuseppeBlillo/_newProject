package classes.Enumerations;

public enum TipoUtenteEnum {
    ORGANIZZATORE("Master"),
    PARTECIPANTE("Utente semplice");

    private String permessiUtente;

    TipoUtenteEnum(String permessiUtente) {
        this.permessiUtente = permessiUtente;
    }

    public String getPermessiUtente() {
        return permessiUtente;
    }

    public void setPermessiUtente(String permessiUtente) {
        this.permessiUtente = permessiUtente;
    }
}
