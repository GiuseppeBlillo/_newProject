package java13g3.justMeet.enumerations;

public enum RatingEnum {
    BAD(1),
    DECENT(2),
    NORMAL(3),
    VERYGOOD(4),
    PERFECT(5);

    private Integer id;

    RatingEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
