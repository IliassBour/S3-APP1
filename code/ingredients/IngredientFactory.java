package ingredients;

/**
 * Classe pour créé les objets des différents ingrédients
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class IngredientFactory {
    /**
     * Crée un objet selon le type d'ingrédient envoyer en paramètre
     * @return l'objet de l'ingrédient créé
     */
    public Ingredient creerIngredient(String nom, String description, TypeIngredient typeIngredient) {
        Ingredient ingredient;

        switch (typeIngredient) {
            case FRUIT:
                ingredient = new Fruit(nom, description);
                break;
            case LEGUME:
                ingredient = new Legume(nom, description);
                break;
            case VIANDE:
                ingredient = new Viande(nom, description);
                break;
            case EPICE:
                ingredient = new Epice(nom, description);
                break;
            case LAITIER:
                ingredient = new Laitier(nom, description);
                break;
            default:
                ingredient = new Ingredient(nom, description, null);
        }

        return ingredient;
    }
}
