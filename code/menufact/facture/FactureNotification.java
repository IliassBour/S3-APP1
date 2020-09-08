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
public class FactureNotification implements Notification<PlatChoisi> {

    /**
     * Crée une nouvelle commande
     */
    @Override
    public void Notifier(ArrayList<PlatChoisi> platsCommande){
        Commande commande = new Commande(platsCommande);
        commande.PoursuivreCommande();
    }
}
