package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.Date;

public class FactureController {
    private Facture facture;
    private FactureView factureView;

    public FactureController(Facture facture, FactureView factureView) {
        this.facture = facture;
        this.factureView = factureView;
    }

    public FactureController(String description, FactureView factureView) {
        this.facture = new Facture(description);
        this.factureView = factureView;
    }

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
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()
    {
        facture.payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
        facture.fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
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
     * @throws FactureException Seulement si la facture est OUVERTE
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

    public void printFacture() {
        factureView.printFacture(this.genererFacture());
    }
}
