package ingredients;

public class Legume extends Ingredient{
    public Legume() {
        setTypeIngredient(TypeIngredient.LEGUME);
    }

    public Legume(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
