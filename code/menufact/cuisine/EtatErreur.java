package menufact.cuisine;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * État "Erreur" d'une commande, arrive lorsqu'il n'y a pas assez d'ingrédients dans l'inventaire ou que l'ingrédient n'existe pas
 */
public class EtatErreur implements CommandeEtat{
    /**
     * Constructeur de base
     */
    public EtatErreur(){}

    /**
     * Se retourne soi-même
     * @return EtatErreur
     */
    @Override
    public CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi) {
        System.out.println(this.toString());
        return this;
    }

    @Override
    public String toString() {
        return "Erreur";
    }
}
