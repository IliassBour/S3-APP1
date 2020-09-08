package test;

import ingredients.Ingredient;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void getNom() throws IngredientException{
        Ingredient ingredient = new Ingredient("nom","description", null);

        if(!("nom".equals(ingredient.getNom()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.getNom()");
        }
    }

    @Test
    public void setNom() throws IngredientException {
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("pomme");

        if(!("pomme".equals(ingredient.getNom()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.setNom()");
        }
    }

    @Test
    public void getDescription() throws IngredientException {
        Ingredient ingredient = new Ingredient("nom","description", null);

        if(!("description".equals(ingredient.getDescription()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.getDescription()");
        }
    }

    @Test
    public void setDescription() throws IngredientException {
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("pomme");

        if(!("pomme".equals(ingredient.getDescription()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.setDescription()");
        }
    }

    @Test
    public void getTypeIngredient() throws IngredientException {
        Ingredient ingredient = new Ingredient("nom","description", TypeIngredient.EPICE);

        if(!(TypeIngredient.EPICE.equals(ingredient.getTypeIngredient()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.getTypeIngredient()");
        }
    }

    @Test
    public void setTypeIngredient() throws IngredientException {
        Ingredient ingredient = new Ingredient();
        ingredient.setTypeIngredient(TypeIngredient.VIANDE);

        if(!(TypeIngredient.VIANDE.equals(ingredient.getTypeIngredient()))) {
            throw new IngredientException("Erreur pour la méthode Ingredient.setTypeIngredient()");
        }
    }
}