import classes.Enumerations.CategoriaEnum;
import classes.Models.Utente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Utente u = new Utente(1, "pippo", "franco", 18, "pippofranco@intellij.com");
        List<CategoriaEnum> listaInteressi = new ArrayList<>();
        listaInteressi.add(CategoriaEnum.RELIGIONE);
        listaInteressi.add(CategoriaEnum.SPORTEFITNESS);
        listaInteressi.add(CategoriaEnum.RELIGIONE);
        u.setInteressiUtente(listaInteressi);
    }
}