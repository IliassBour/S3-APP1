package menufact.cuisine;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * État "En preparation" d'une commande, 2ème état
 */
public class EtatEnPreparation implements CommandeEtat{
    /**
     * Constructeur de base
     */
    public EtatEnPreparation(){}

    /**
     * Passe de l'état "En preparation" à l'état "Terminer"
     * @return Prochain état (Terminer)
     */
    @Override
    public CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi) {
        return new EtatTerminer();
    }

    @Override
    public String toString() {
        return "En preparation";
    }
}
