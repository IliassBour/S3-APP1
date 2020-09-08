package menufact.facture;

import menufact.Client;
import menufact.Notification;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Le controlleur de la facture
 * @author Iliass Bourabaa
 * @version 1.0
 */
public class FactureController {
    private Facture facture;
    private FactureView factureView;
    private ArrayList<Notification> notifications;

    /**
     * Constructeur avec en paramètre un objet Facture
     */
    public FactureController(Facture facture) {
        this.facture = facture;
        this.factureView = new FactureView();
        this.notifications = new ArrayList<Notification>();
        this.notifications.add(new FactureNotification());
    }

    /**
     * Constructeur avec en paramètre la description de la facture
     */
    public FactureController(String description) {
        this.facture = new Facture(description);
        this.factureView =  new FactureView();
        this.notifications = new ArrayList<Notification>();
        this.notifications.add(new FactureNotification());
    }

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        facture.associerClient(client);
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        return facture.sousTotal();
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return facture.total();
    }

    /**
     * Permet de changer l'état de la facture à PAYEE
     */
    public void payer() throws FactureException {
        if(facture.getEtat() == FactureEtat.FERMEE) {
            facture.payer();
        } else {
            throw new FactureException("Il faut que la facture soit fermée avant de la payer");
        }
    }

    /**
     * Permet de changer l'état de la facture à FERMEE
     */
    public void fermer()
    {
        facture.fermer();

        for(Notification notif : this.notifications){
            notif.Notifier(this.facture.getPlatchoisi());
        }
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     */
    public void ouvrir() throws FactureException
    {
        facture.ouvrir();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return facture.getEtat();
    }


    /**
     *
     * @param p un plat choisi
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        facture.ajoutePlat(p);
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return facture.toString();
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        return facture.genererFacture();
    }

    /**
     * Appele la vue de la facture pour afficher à l'écran la facture
     */
    public void printFacture() {
        factureView.printFacture(facture.genererFacture());
    }
}
