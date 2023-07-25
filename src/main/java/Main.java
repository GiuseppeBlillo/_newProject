import classes.Enumerations.CategoriaEnum;
import classes.Utente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CategoriaEnum> listaPietro = new ArrayList<>();
        listaPietro.add(10, CategoriaEnum.SPORTEFITNESS);
        Utente u = new Utente(1,"pietro","croce", 32, "maschio", "pietrocross@cross.it", 800900313, listaPietro);
    }
}