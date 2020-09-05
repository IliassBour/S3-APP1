package ingredients;

import ingredients.exceptions.IngredientException;

public class IngredientInventaire extends Ingredient {
    private Ingredient ingredient;
    private int quantite;

    public IngredientInventaire(String nom, String description, TypeIngredient typeIngredient, int quantite) {
        this.ingredient = new IngredientFactory().creerIngredient(nom, description, typeIngredient);
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
