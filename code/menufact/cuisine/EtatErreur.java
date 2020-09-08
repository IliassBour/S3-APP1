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
        return this;
    }

    @Override
    public String toString() {
        return "Erreur";
    }
}
