package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

public class LaitierTest {
    @Test
    public void LaitierTest() throws IngredientException {
        Laitier laitier = new Laitier("nom", "description");

        if(laitier.getClass() != Laitier.class || laitier.getNom() != "nom"
                || laitier.getDescription() != "description" || laitier.getTypeIngredient() != TypeIngredient.LAITIER) {
            throw new IngredientException("Erreur dans la création d'un objet Laitier");
        }
    }
}