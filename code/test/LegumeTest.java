package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

public class LegumeTest {
    @Test
    public void LegumeTest() throws IngredientException {
        Legume legume = new Legume("nom", "description");

        if(legume.getClass() != Legume.class || legume.getNom() != "nom"
                || legume.getDescription() != "description" || legume.getTypeIngredient() != TypeIngredient.LEGUME) {
            throw new IngredientException("Erreur dans la création d'un objet Legume");
        }
    }
}