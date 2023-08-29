package java13g3.justMeet.enumerations;

public enum CategoryEnum {
    SPORT(1),
    ARTS(2),
    SOCIALACTIVITIES(3),
    ANIMALS(4),
    AMBIENT(5),
    FAMILY(6),
    CARRIERS(7),
    MUSIC(8),
    LANGUAGE(9),
    POLITICAL(10),
    RELIGION(11),
    HEALTH(12),
    SCIENCE(13),
    WRITING(14),
    COACHING(15),
    TECHNOLOGIES(16),
    TRAVEL(17),
    SHOPPING(18),
    OTHER(19);

    private Integer id;

    CategoryEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
