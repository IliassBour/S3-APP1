package menufact.facture;

import menufact.Notification;
import menufact.cuisine.Commande;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Classe de notification de la facture. Averti l'arrivé d'un nouveau plat à faire (fais une commande)
 * @author Pedro Scoccimarro
 * @version 1.0
 */
public class FactureNotification implements Notification {

    /**
     * Crée une nouvelle commande
     */
    @Override
    public void Notifier(){
        Commande commande = new Commande();
        commande.PoursuivreCommande();
    }

    /**
     * Notifie la cuisine avec le plat commandé
     * @param platsCommande
     */
    public void NotifierCuisine(ArrayList<PlatChoisi> platsCommande){
        Commande commande = new Commande(platsCommande);
        commande.PoursuivreCommande();
    }
}
