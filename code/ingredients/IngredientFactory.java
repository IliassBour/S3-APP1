package ingredients;

public class IngredientFactory {
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
