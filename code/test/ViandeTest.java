package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

public class ViandeTest {
    @Test
    public void ViandeTest() throws IngredientException {
        Viande viande = new Viande("nom", "description");

        if(viande.getClass() != Viande.class || viande.getNom() != "nom"
                || viande.getDescription() != "description" || viande.getTypeIngredient() != TypeIngredient.VIANDE) {
            throw new IngredientException("Erreur dans la création d'un objet Viande");
        }
    }
}