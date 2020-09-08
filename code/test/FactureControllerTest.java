package test;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.TypeIngredient;
import menufact.Client;
import menufact.cuisine.Cuisine;
import menufact.facture.FactureController;
import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FactureControllerTest {

    @Test
    public void associerClient() throws FactureException {
        FactureController factureController = new FactureController("description");
        Client client = new Client(1, "nom", "1");

        factureController.associerClient(client);
        if(!factureController.toString().contains("client=menufact.Client{idClient=1, nom='nom', numeroCarteCredit='1'}")) {
            throw new FactureException("Erreur dans la méthode FactureController.associerClient()");
        }

        Client client2 = new Client(2, "nom2", "2");

        factureController.associerClient(client2);
        if(!factureController.toString().contains("client=menufact.Client{idClient=2, nom='nom2', numeroCarteCredit='2'}")) {
            throw new FactureException("Erreur dans la méthode FactureController.associerClient()");
        }
    }

    @Test
    public void sousTotal() throws FactureException {
        FactureController factureController = new FactureController("description");

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        PlatAuMenu platAuMenu2 = new PlatAuMenu(2,"salade",5);
        PlatAuMenu platAuMenu3 = new PlatAuMenu(3,"paté chinois",15);

        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);
        PlatChoisi platChoisi2 = new PlatChoisi(platAuMenu2,3);
        PlatChoisi platChoisi3 = new PlatChoisi(platAuMenu3,1);

        factureController.ajoutePlat(platChoisi1);
        factureController.ajoutePlat(platChoisi2);
        factureController.ajoutePlat(platChoisi3);

        if(factureController.sousTotal() != 12*2+5*3+15) {
            throw new FactureException("Erreur dans la méthode FactureController.sousTotal()");
        }
    }

    @Test
    public void total() throws FactureException {
        FactureController factureController = new FactureController("description");

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        PlatAuMenu platAuMenu2 = new PlatAuMenu(2,"salade",5);
        PlatAuMenu platAuMenu3 = new PlatAuMenu(3,"paté chinois",15);

        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);
        PlatChoisi platChoisi2 = new PlatChoisi(platAuMenu2,3);
        PlatChoisi platChoisi3 = new PlatChoisi(platAuMenu3,1);

        factureController.ajoutePlat(platChoisi1);
        factureController.ajoutePlat(platChoisi2);
        factureController.ajoutePlat(platChoisi3);

        double sousTotal = 12*2+5*3+15;
        if(factureController.total() != sousTotal+sousTotal*0.05+sousTotal*(1+0.05)*0.095) {
            throw new FactureException("Erreur dans la méthode FactureController.total()");
        }
    }

    @Test
    public void payer() throws FactureException {
        FactureController factureController = new FactureController("description");

        ArrayList<IngredientInventaire> ingredientInventaires1 = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires1.add(ingredient1);

        Cuisine cuisine = Cuisine.CreerCuisine(ingredientInventaires1);

        ArrayList<IngredientInventaire> ingredientInventaires2 = new ArrayList<>();
        IngredientInventaire ingredient2 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires2.add(ingredient2);

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        platAuMenu1.setIngredientInventaire(ingredientInventaires2);
        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);

        factureController.ajoutePlat(platChoisi1);

        try {
            factureController.payer();
        } catch (FactureException exception) {
            System.out.println(exception);
        }
System.out.println(factureController.toString());
        factureController.fermer();
        factureController.payer();

        if(factureController.getEtat() != FactureEtat.PAYEE) {
            throw new FactureException("Erreur dans la méthode FactureController.payer()");
        }
    }

    @Test
    public void fermer() throws FactureException {
        FactureController factureController = new FactureController("description");

        ArrayList<IngredientInventaire> ingredientInventaires1 = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires1.add(ingredient1);

        Cuisine cuisine = Cuisine.CreerCuisine(ingredientInventaires1);

        ArrayList<IngredientInventaire> ingredientInventaires2 = new ArrayList<>();
        IngredientInventaire ingredient2 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires2.add(ingredient2);

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        platAuMenu1.setIngredientInventaire(ingredientInventaires2);
        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);

        factureController.ajoutePlat(platChoisi1);

        factureController.fermer();

        if(factureController.getEtat() != FactureEtat.FERMEE) {
            throw new FactureException("Erreur dans la méthode FactureController.fermer()");
        }
    }

    @Test
    public void ouvrir() throws FactureException {
        FactureController factureController = new FactureController("description");

        ArrayList<IngredientInventaire> ingredientInventaires1 = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires1.add(ingredient1);

        Cuisine cuisine = Cuisine.CreerCuisine(ingredientInventaires1);

        ArrayList<IngredientInventaire> ingredientInventaires2 = new ArrayList<>();
        IngredientInventaire ingredient2 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires2.add(ingredient2);

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        platAuMenu1.setIngredientInventaire(ingredientInventaires2);
        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);

        factureController.ajoutePlat(platChoisi1);

        factureController.fermer();
        factureController.ouvrir();

        if(factureController.getEtat() != FactureEtat.OUVERTE) {
            throw new FactureException("Erreur dans la méthode FactureController.ouvrir()");
        }
    }

    @Test
    public void getEtat() throws FactureException {
        FactureController factureController = new FactureController("description");

        ArrayList<IngredientInventaire> ingredientInventaires1 = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires1.add(ingredient1);

        Cuisine cuisine = Cuisine.CreerCuisine(ingredientInventaires1);

        ArrayList<IngredientInventaire> ingredientInventaires2 = new ArrayList<>();
        IngredientInventaire ingredient2 = new IngredientInventaire("tomate","description", TypeIngredient.FRUIT,10);
        ingredientInventaires2.add(ingredient2);

        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        platAuMenu1.setIngredientInventaire(ingredientInventaires2);
        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);

        factureController.ajoutePlat(platChoisi1);

        if(factureController.getEtat() != FactureEtat.OUVERTE) {
            throw new FactureException("Erreur dans la méthode FactureController.getEtat()");
        }

        factureController.fermer();

        if(factureController.getEtat() != FactureEtat.FERMEE) {
            throw new FactureException("Erreur dans la méthode FactureController.getEtat()");
        }

        factureController.payer();

        if(factureController.getEtat() != FactureEtat.PAYEE) {
            throw new FactureException("Erreur dans la méthode FactureController.getEtat()");
        }
    }

    @Test
    public void ajoutePlat() throws FactureException {
        FactureController factureController = new FactureController("description");
        PlatAuMenu platAuMenu1 = new PlatAuMenu(1,"spaghetti",12);
        PlatChoisi platChoisi1 = new PlatChoisi(platAuMenu1,2);

        factureController.ajoutePlat(platChoisi1);

        if(!(factureController.toString().contains("quantite=2") && factureController.toString().contains("code=1")
                && factureController.toString().contains("description='spaghetti'") && factureController.toString().contains("prix=12.0"))) {
            throw new FactureException("Erreur dans la méthode FactureController.ajoutePlat");
        }
    }
}