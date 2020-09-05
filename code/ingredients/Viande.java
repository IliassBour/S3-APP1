package ingredients;

public class Viande extends Ingredient{
    public Viande() {
        setTypeIngredient(TypeIngredient.VIANDE);
    }

    public Viande(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.VIANDE);
    }
}
