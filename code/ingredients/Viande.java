package ingredients;

/**
 * Un ingrédient de type viande du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Viande extends Ingredient{
    /**
     * Constructeur par défault
     */
    public Viande() {
        setTypeIngredient(TypeIngredient.VIANDE);
    }

    /**
     * Constructeur avec les paramètres de la viande
     */
    public Viande(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.VIANDE);
    }
}
