package ingredients;

/**
 * Un ingrédient de type épice du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Epice extends Ingredient {
    /**
     * Constructeur par défault
     */
    public Epice() {
        setTypeIngredient(TypeIngredient.EPICE);
    }

    /**
     * Constructeur avec les paramètres de l'épice
     */
    public Epice(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.EPICE);
    }
}
