package ingredients;

/**
 * Un ingrédient de type légume du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Legume extends Ingredient{
    /**
     * Constructeur par défault
     */
    public Legume() {
        setTypeIngredient(TypeIngredient.LEGUME);
    }

    /**
     * Constructeur avec les paramètres du légume
     */
    public Legume(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
