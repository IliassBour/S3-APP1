package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

public class FruitTest {
    @Test
    public void FruitTest() throws IngredientException {
        Fruit fruit = new Fruit("nom", "description");

        if(fruit.getClass() != Fruit.class || fruit.getNom() != "nom"
                || fruit.getDescription() != "description" || fruit.getTypeIngredient() != TypeIngredient.FRUIT) {
            throw new IngredientException("Erreur dans la création d'un objet Fruit");
        }
    }
}