package ingredients;

public class Epice extends Ingredient {
    public Epice() {
        setTypeIngredient(TypeIngredient.EPICE);
    }

    public Epice(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.EPICE);
    }
}
