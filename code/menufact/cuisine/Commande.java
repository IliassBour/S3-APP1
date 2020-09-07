package menufact.cuisine;

import menufact.Notification;
import menufact.plats.PlatChoisi;
import menufact.cuisine.EtatCommande;

import java.util.ArrayList;

/**
 * Classe de gestion du plat dans la cuisine
 * @author Pedro Scoccimarro
 * @version 1.0
 */
public class Commande {
    private ArrayList<Notification> notifications;
    private CommandeEtat etat;
    private ArrayList<PlatChoisi> platsChoisi;

    /**
     * Constructeur de base
     */
    public Commande(){
        this.etat = new EtatCommande();
    };

    /**
     * Constructeur avec un plat
     * @param platsAFaire
     */
    public Commande(ArrayList<PlatChoisi> platsAFaire){
        this.etat = new EtatCommande();
        this.platsChoisi = platsAFaire;
    };

    /**
     * @return L'état de la commande
     */
    public CommandeEtat getEtat(){return this.etat;}

    /**
     * Change l'état de la commande
     */
    public void PoursuivreCommande(){
        do{
            this.etat = this.getEtat().prochainEtat(platsChoisi);
        }while(this.getEtat().toString() != "Servi" && this.getEtat().toString() != "Erreur");
        System.out.println(this.getEtat().toString());
    };

}
