package menufact.cuisine;

import menufact.cuisine.exceptions.InventaireException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * État "Commandé" d'une commande, 1er état
 */
public class EtatCommande implements CommandeEtat{

    /**
     * Constructeur de base
     */
    public EtatCommande(){}

    /**
     * Passe de l'état "Commandé" à "En preparation"
     * @return Prochain état (En preparation)
     */
    @Override
    public CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi) {
        System.out.println(this.toString());
        Cuisine cuisine = Cuisine.getInstance();

        try{
            for(PlatChoisi plat : platsChoisi){
                cuisine.enleverIngredients(plat.getPlat().getIngredientInventaire());
            }
        }
        catch(InventaireException invE){
            System.out.println(invE.getMessage());
            return new EtatErreur();
        }

        return new EtatEnPreparation();
    }

    @Override
    public String toString() {
        return "Commandé";
    }
}
