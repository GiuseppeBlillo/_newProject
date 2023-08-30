package java13g3.justMeet.enumerations;

public enum LanguageEnum {
    ENGLISH(1),
    DEUTSCH(2),
    FRENCH(3),
    SPANISH(4),
    JAPANESE(5),
    ITALIAN(6),
    CHINESE(7);

    private Integer id;

    LanguageEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
