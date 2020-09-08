package test;

import ingredients.exceptions.IngredientException;
import ingredients.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientInventaireTest {

    @Test
    public void getIngredient() throws IngredientException {
        IngredientInventaire ingredientInventaire = new IngredientInventaire("nom", "description", TypeIngredient.EPICE, 10);

        if(ingredientInventaire.getIngredient().getClass() != Epice.class
                || ingredientInventaire.getIngredient().getNom() != "nom"
                || ingredientInventaire.getIngredient().getDescription() != "description"
                || ingredientInventaire.getIngredient().getTypeIngredient() != TypeIngredient.EPICE) {
            throw new IngredientException("Erreur pour la méthode IngredientInventaire.getIngredient");
        }
    }

    @Test
    public void getQuantite() throws IngredientException {
        IngredientInventaire ingredientInventaire = new IngredientInventaire("nom", "description", TypeIngredient.LAITIER, 10);

        if(ingredientInventaire.getQuantite() != 10) {
            throw new IngredientException("Erreur pour la méthode IngredientInventaire.getQuantite");
        }
    }

    @Test
    public void setQuantite() throws IngredientException {
        IngredientInventaire ingredientInventaire = new IngredientInventaire("nom", "description", TypeIngredient.LAITIER, 10);

        try {
            ingredientInventaire.setQuantite(20);
        } catch (IngredientException exception) {
            throw exception;
        }

        try {
            ingredientInventaire.setQuantite(-10);
        } catch (IngredientException exception) {
            System.err.println(exception);
        }

        if(ingredientInventaire.getQuantite() != 20) {
            throw new IngredientException("Erreur pour la méthode IngredientInventaire.setQuantite");
        }
    }
}