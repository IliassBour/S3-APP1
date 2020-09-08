package test;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import menufact.cuisine.Cuisine;
import menufact.cuisine.exceptions.InventaireException;
import org.junit.Test;

import java.util.ArrayList;

public class CuisineTest {
    @Test
    public void getInstance() throws InventaireException {
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        IngredientInventaire ingredient2 = new IngredientInventaire("pomme", "description2", TypeIngredient.FRUIT, 5);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Cuisine cuisine1 = Cuisine.CreerCuisine(ingredients);
        Cuisine cuisine2 = Cuisine.getInstance();

        if(cuisine1.getInstance() != cuisine2.getInstance()) {
            throw new InventaireException("Erreur avec la méthode Cuisine.getInstance");
        }
    }

    @Test
    public void getInventaire() throws InventaireException {
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        IngredientInventaire ingredient2 = new IngredientInventaire("pomme", "description2", TypeIngredient.FRUIT, 5);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Cuisine cuisine1 = Cuisine.CreerCuisine(ingredients);

        if(cuisine1.getInventaire().get(0).getIngredient().getNom() != "patate"
                || cuisine1.getInventaire().get(0).getIngredient().getDescription() != "description1"
                || cuisine1.getInventaire().get(0).getIngredient().getTypeIngredient() != TypeIngredient.LEGUME
                || cuisine1.getInventaire().get(0).getQuantite() != 20) {
            throw new InventaireException("Erreur pour la méthode Cuisine.getInventaire");
        }

        if(cuisine1.getInventaire().get(1).getIngredient().getNom() != "pomme"
                || cuisine1.getInventaire().get(1).getIngredient().getDescription() != "description2"
                || cuisine1.getInventaire().get(1).getIngredient().getTypeIngredient() != TypeIngredient.FRUIT
                || cuisine1.getInventaire().get(1).getQuantite() != 5) {
            throw new InventaireException("Erreur pour la méthode Cuisine.getInventaire");
        }
    }

    @Test
    public void enleverIngredients() throws IngredientException, InventaireException {
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        ingredients.add(ingredient1);

        ArrayList<IngredientInventaire> ingredientsAEnlever = new ArrayList<>();
        IngredientInventaire ingredient2 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 5);
        ingredientsAEnlever.add(ingredient2);

        Cuisine cuisine1 = Cuisine.CreerCuisine(ingredients);
        cuisine1.enleverIngredients(ingredientsAEnlever);

        if(cuisine1.getInventaire().get(0).getQuantite() != 15) {
            throw new InventaireException("Erreur pour la méthode Cuisine.enleverIngredients");
        }

        ingredient2.setQuantite(15);
        cuisine1.enleverIngredients(ingredientsAEnlever);

        if(cuisine1.getInventaire().get(0).getQuantite() != 0) {
            throw new InventaireException("Erreur pour la méthode Cuisine.enleverIngredients");
        }
    }
}
