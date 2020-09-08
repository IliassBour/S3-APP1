package ingredients;

import ingredients.exceptions.IngredientException;

/**
 * Inventaire d'un ingrédient du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class IngredientInventaire extends Ingredient {
    private Ingredient ingredient;
    private int quantite;

    /**
     * Constructeur avec les paramètres de l'inventaire de l'ingrédient
     */
    public IngredientInventaire(String nom, String description, TypeIngredient typeIngredient, int quantite) {
        this.ingredient = new IngredientFactory().creerIngredient(nom, description, typeIngredient);
        this.quantite = quantite;
    }

    /**
     * @return l'ingrédient de l'inventaire de l'ingrédient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * @return la quantité de l'inventaire de l'ingrédient
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Change la quantité de l'inventaire de l'ingrédient
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    @Override
    public String toString() {
        return ingredient.getNom() + "/" + ingredient.getTypeIngredient() + "/" + this.getQuantite();
    }
}
