package ingredients;

/**
 * Un ingrédient de type laitier du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Laitier extends  Ingredient{
    /**
     * Constructeur par défault
     */
    public Laitier() {
        setTypeIngredient(TypeIngredient.LAITIER);
    }

    /**
     * Constructeur avec les paramètres du produit laitier
     */
    public Laitier(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LAITIER);
    }
}
