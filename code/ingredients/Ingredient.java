package ingredients;

/**
 * Un ingrédient du menu
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    /**
     * Constructeur par défault
     */
    public Ingredient() {}

    /**
     * Constructeur avec les paramètres de l'ingrédient
     */
    public Ingredient(String nom, String description, TypeIngredient typeIngredient) {
        this.nom = nom;
        this.description = description;
        this.typeIngredient = typeIngredient;
    }

    /**
     *
     * @return le nom de l'ingrédient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom de l'ingrédient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return la description de l'ingrédient
     */
    public String getDescription() {
        return description;
    }

    /**
     *  Change la description de l'ingrédient
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return le type d'ingrédient de l'ingrédient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Change le type d'ingrédient de l'ingrédient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
