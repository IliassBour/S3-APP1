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
        System.out.println(this.toString());
        return this;
    }

    @Override
    public String toString() {
        return "Servi";
    }
}
