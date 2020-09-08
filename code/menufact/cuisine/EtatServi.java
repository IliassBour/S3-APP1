package menufact.cuisine;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * État "Servi" d'une commande, 4ème état
 */
public class EtatServi implements CommandeEtat{
    /**
     * Constructeur de base
     */
    public EtatServi(){}

    /**
     * Se retourne soi-même
     * @return EtatServi
     */
    @Override
    public CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi) {
        return this;
    }

    @Override
    public String toString() {
        return "Servi";
    }
}
