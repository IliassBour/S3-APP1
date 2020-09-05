package ingredients;

/**
 * Un ingrédient de type fruit du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Fruit extends Ingredient{
    /**
     * Constructeur par défault
     */
    public Fruit() {
        setTypeIngredient(TypeIngredient.FRUIT);
    }

    /**
     * Constructeur avec les paramètres du fruit
     */
    public Fruit(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.FRUIT);
    }
}
