package ingredients;

public class Laitier extends  Ingredient{
    public Laitier() {
        setTypeIngredient(TypeIngredient.LAITIER);
    }

    public Laitier(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LAITIER);
    }
}
