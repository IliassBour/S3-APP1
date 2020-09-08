package menufact.cuisine;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import menufact.cuisine.exceptions.InventaireException;
import java.util.ArrayList;

/**
 * Classe singleton contenant l'inventaire du restaurant
 * @author Pedro Scoccimarro
 * @version 1.0
 */
public class Cuisine {
    private static Cuisine instanceCuisine;
    private ArrayList<IngredientInventaire> inventaire;

    /**
     * Constructeur privé du singleton 'Cuisine'
     */
    private Cuisine(){ this.inventaire = null; }

    /**
     * Constructeur public de 'Cuisine'. Permet d'indiquer une quantité initiale de chaque 'Ingredient'
     * Si l'instance est déjà crée, ne fait rien
     * @param "ArrayList<IngredientInventaire>"
     */
    public static Cuisine CreerCuisine(ArrayList<IngredientInventaire> inventaireInitial){
        if(Cuisine.instanceCuisine == null){
            Cuisine.instanceCuisine = new Cuisine();
            Cuisine.instanceCuisine.setInventaire(inventaireInitial);
            return Cuisine.instanceCuisine;
        }
        return Cuisine.instanceCuisine;
    }

    /**
     * @return Crée l'instance cuisine si non encore initialisé ou renvoi l'unique instance de celle-ci
     */
    public static Cuisine getInstance(){
        if(Cuisine.instanceCuisine != null){
            return Cuisine.instanceCuisine;
        }
        Cuisine.instanceCuisine = new Cuisine();
        return Cuisine.instanceCuisine;
    }

    /**
     * @return Retourne la liste des ingrédients dans la cuisine avec leurs quantités
     */
    public ArrayList<IngredientInventaire> getInventaire(){
        return this.inventaire;
    }

    /**
     * Établi l'inventaire, utilisé uniquement dans la fonction "CreerCuisine"
     * @param inventaireInitial
     */
    private void setInventaire(ArrayList<IngredientInventaire> inventaireInitial){
        this.inventaire = inventaireInitial;
    }

    /**
     * Cette méthode vérifie s'il y a assez d'ingrédients dans l'inventaire et si oui, les retire de l'inventaire
     * Vérifie aussi si l'ingrédient éxiste dans l'inventaire selon son nom
     * @param "ArrayList<IngredientInventaire>" des ingrédients utilisés pour créer un plat
     * @exception "InventaireException" Lorsqu'il manque d'un ingrédient dans l'inventaire ou lorsque celui-ci n'est pas présent dans l'inventaire
     */
    public void enleverIngredients(ArrayList<IngredientInventaire> ingredientsUtilises) throws InventaireException {
        for (IngredientInventaire ingredient : ingredientsUtilises) {
            for(IngredientInventaire ingredientInv : this.inventaire){
                if(ingredient.getIngredient().getNom().equals(ingredientInv.getIngredient().getNom())){
                    if(ingredient.getQuantite() > ingredientInv.getQuantite()){
                        throw new InventaireException("Il n'y a pas assez d'ingrédients pour faire ce plat");
                    }
                    try{
                        ingredientInv.setQuantite(ingredientInv.getQuantite()-ingredient.getQuantite());
                    }
                    catch (IngredientException ingE){
                        System.out.println(ingE.getMessage());
                    }
                    break;
                }
                throw new InventaireException("Cet ingrédient n'existe pas dans l'inventaire");
            }
        }
    }
}