package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IngredientFactoryTest {

    @Test
    public void creerIngredientViande() throws IngredientException {
        Ingredient ingredient = new IngredientFactory().creerIngredient("nom", "description", TypeIngredient.VIANDE);
        Ingredient ingredient1 = new Viande("nom", "description");

        if (ingredient.getClass() != ingredient1.getClass()) {
            throw new IngredientException("Erreur pour de type de classe de l'ingrédient créé");
        }

        if (ingredient.getNom() != ingredient1.getNom() || ingredient.getDescription() != ingredient1.getDescription()
                || ingredient.getTypeIngredient() != ingredient1.getTypeIngredient()) {
            throw new IngredientException("Erreur pour un des attributs de l'ingrédient créé");
        }
    }

    @Test
    public void creerIngredientFruit() throws IngredientException {
        Ingredient ingredient = new IngredientFactory().creerIngredient("nom1", "description1", TypeIngredient.FRUIT);
        Ingredient ingredient1 = new Fruit("nom1", "description1");

        if (ingredient.getClass() != ingredient1.getClass()) {
            throw new IngredientException("Erreur pour de type de classe de l'ingrédient créé");
        }

        if (ingredient.getNom() != ingredient1.getNom() || ingredient.getDescription() != ingredient1.getDescription()
                || ingredient.getTypeIngredient() != ingredient1.getTypeIngredient()) {
            throw new IngredientException("Erreur pour un des attributs de l'ingrédient créé");
        }
    }

    @Test
    public void creerIngredientEpice() throws IngredientException {
        Ingredient ingredient = new IngredientFactory().creerIngredient("nom2", "description2", TypeIngredient.EPICE);
        Ingredient ingredient1 = new Epice("nom2", "description2");

        if (ingredient.getClass() != ingredient1.getClass()) {
            throw new IngredientException("Erreur pour de type de classe de l'ingrédient créé");
        }

        if (ingredient.getNom() != ingredient1.getNom() || ingredient.getDescription() != ingredient1.getDescription()
                || ingredient.getTypeIngredient() != ingredient1.getTypeIngredient()) {
            throw new IngredientException("Erreur pour un des attributs de l'ingrédient créé");
        }
    }

    @Test
    public void creerIngredientLegume() throws IngredientException {
        Ingredient ingredient = new IngredientFactory().creerIngredient("nom3", "description3", TypeIngredient.LEGUME);
        Ingredient ingredient1 = new Legume("nom3", "description3");

        if(ingredient.getClass() != ingredient1.getClass()) {
            throw new IngredientException("Erreur pour de type de classe de l'ingrédient créé");
        }

        if(ingredient.getNom() != ingredient1.getNom() || ingredient.getDescription() != ingredient1.getDescription()
                || ingredient.getTypeIngredient() != ingredient1.getTypeIngredient()) {
            throw new IngredientException("Erreur pour un des attributs de l'ingrédient créé");
        }
    }

    @Test
    public void creerIngredientLaitier() throws IngredientException {
        Ingredient ingredient = new IngredientFactory().creerIngredient("nom4", "description4", TypeIngredient.LAITIER);
        Ingredient ingredient1 = new Laitier("nom4", "description4");

        if(ingredient.getClass() != ingredient1.getClass()) {
            throw new IngredientException("Erreur pour de type de classe de l'ingrédient créé");
        }

        if(ingredient.getNom() != ingredient1.getNom() || ingredient.getDescription() != ingredient1.getDescription()
                || ingredient.getTypeIngredient() != ingredient1.getTypeIngredient()) {
            throw new IngredientException("Erreur pour un des attributs de l'ingrédient créé");
        }
    }
}