package ingredients;

public class Fruit extends Ingredient{
    public Fruit() {
        setTypeIngredient(TypeIngredient.FRUIT);
    }

    public Fruit(String nom, String description) {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.FRUIT);
    }
}
