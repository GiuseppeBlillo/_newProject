package classes.Enumerations;

public enum TipoUtenteEnum {
    ORGANIZZATORE("Master"),
    PARTECIPANTE("Utente semplice");

    private String permessiUtente;

    TipoUtenteEnum(String permessiUtente) {
        this.permessiUtente = permessiUtente;
    }
}
