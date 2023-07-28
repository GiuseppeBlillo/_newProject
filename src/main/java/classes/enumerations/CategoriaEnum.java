package classes.enumerations;

public enum CategoriaEnum {
    SPORTEFITNESS(1),
    ARTECULTURA(2),
    ATTIVITASOCIALI(3),
    BALLO(4),
    ANIMALI(5),
    COMUNITAEAMBIENTE(6),
    GENITORIEFAMIGLIA(7),
    AFFARIECARRIERA(8),
    MUSICA(9),
    LINGUAEIDENTITA(10),
    POLITICAEMOVIMENTI(11),
    RELIGIONE(12),
    SALUTEBENESSERE(13),
    SCIENZAEFORMAZIONE(14),
    SCRITTURA(15),
    SUPPORTOCOACHING(16),
    TECNOLOGIA(17),
    ATTIVITAALLAPERTO(18),
    VIAGGI(19),
    SHOPPING(20),
    ALTRO(21);

    private Integer id;

    CategoriaEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
