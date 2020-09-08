package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

public class EpiceTest {
    @Test
    public void EpiceTest() throws IngredientException {
        Epice epice = new Epice("nom", "description");

        if(epice.getClass() != Epice.class || epice.getNom() != "nom"
                || epice.getDescription() != "description" || epice.getTypeIngredient() != TypeIngredient.EPICE) {
            throw new IngredientException("Erreur dans la création d'un objet Epice");
        }
    }
}