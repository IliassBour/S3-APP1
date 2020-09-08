package menufact.cuisine;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * État "Terminer" d'une commande, 3ème état
 */
public class EtatTerminer implements CommandeEtat{
    /**
     * Constructeur de base
     */
    public EtatTerminer(){}

    /**
     * Passe de l'état "Terminer" à l'état "Servi"
     * @return Prochain état (Servi)
     */
    @Override
    public CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi) {
        return new EtatServi();
    }

    @Override
    public String toString() {
        return "Terminer";
    }
}
