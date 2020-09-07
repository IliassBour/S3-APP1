package menufact.cuisine;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Interface des etats d'une commande
 */
public interface CommandeEtat {
    CommandeEtat prochainEtat(ArrayList<PlatChoisi> platsChoisi);
}
