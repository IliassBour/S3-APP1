package menufact;

import ingredients.*;
import menufact.cuisine.*;
import menufact.exceptions.MenuException;
import menufact.facture.*;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;

import java.util.ArrayList;

public class IterationTest {
    public static void main(String[] args) {
        System.out.println("DÉBUT DE L'ITÉRATION\n");

        try {
            boolean t = true;
            IterationTest tests = new IterationTest();
            FactureController facture = new FactureController("descriptionFacture");
            Client client1 = new Client(1,"nom","1");
            facture.associerClient(client1);

            ArrayList<IngredientInventaire> inventaireCuisine = new ArrayList<>();
            IngredientInventaire ingredientCuisine1 = new IngredientInventaire("ingredient1","description1", TypeIngredient.FRUIT,10);
            IngredientInventaire ingredientCuisine2 = new IngredientInventaire("ingredient2","description2", TypeIngredient.LEGUME,60);
            IngredientInventaire ingredientCuisine3 = new IngredientInventaire("ingredient3","description3", TypeIngredient.VIANDE,35);
            IngredientInventaire ingredientCuisine4 = new IngredientInventaire("ingredient4","description4", TypeIngredient.LAITIER,42);
            IngredientInventaire ingredientCuisine5 = new IngredientInventaire("ingredient5","description5", TypeIngredient.EPICE,900);

            inventaireCuisine.add(ingredientCuisine1);
            inventaireCuisine.add(ingredientCuisine2);
            inventaireCuisine.add(ingredientCuisine3);
            inventaireCuisine.add(ingredientCuisine4);
            inventaireCuisine.add(ingredientCuisine5);

            Cuisine cuisine = Cuisine.CreerCuisine(inventaireCuisine);


            ArrayList<IngredientInventaire> ingredientMenu = new ArrayList<>();
            IngredientInventaire ingredient1 = new IngredientInventaire("ingredient1","description1", TypeIngredient.FRUIT,5);
            IngredientInventaire ingredient2 = new IngredientInventaire("ingredient2","description2", TypeIngredient.LEGUME,6);
            IngredientInventaire ingredient3 = new IngredientInventaire("ingredient3","description3", TypeIngredient.VIANDE,3);
            IngredientInventaire ingredient4 = new IngredientInventaire("ingredient4","description4", TypeIngredient.LAITIER,3);
            IngredientInventaire ingredient5 = new IngredientInventaire("ingredient5","description5", TypeIngredient.EPICE,150);

            PlatAuMenu p1 = new PlatAuMenu(1,"plat1",12);
            PlatAuMenu p2 = new PlatAuMenu(1,"plat4",16);
            PlatSante p3 = new PlatSante(1,"plat2",20,5,7,3);
            PlatEnfant p4 = new PlatEnfant(1,"plat3",9,1);

            ingredientMenu.add(ingredient1);
            ingredientMenu.add(ingredient2);
            ingredientMenu.add(ingredient3);
            p1.setIngredientInventaire(ingredientMenu);

            ingredientMenu = new ArrayList<>();
            ingredientMenu.add(ingredient4);
            ingredientMenu.add(ingredient2);
            p2.setIngredientInventaire(ingredientMenu);

            ingredientMenu = new ArrayList<>();
            ingredientMenu.add(ingredient5);
            ingredientMenu.add(ingredient2);
            ingredientMenu.add(ingredient4);
            p3.setIngredientInventaire(ingredientMenu);

            ingredientMenu = new ArrayList<>();
            ingredientMenu.add(ingredient3);
            ingredientMenu.add(ingredient5);
            p4.setIngredientInventaire(ingredientMenu);

            Menu menu = new Menu("descriptionMenu");

            tests.test1(t, cuisine);
            tests.test2(t, p1, p2, p3, p4);
            tests.test3(t, menu, p1, p2, p3, p4);
            tests.test4(t,facture, menu);
            tests.test5(t, facture);
        }catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }
        System.out.println("\nFIN DE L'ITÉRATION");
    }

    private void test1(boolean trace, Cuisine cuisine)
    {
        System.out.println("=== test1_AfficherCuisine");
        if(trace)
        {
            System.out.print(cuisine.toString()+"\n\n");
        }
    }

    private void test2(boolean trace, PlatAuMenu p1, PlatAuMenu p2, PlatSante p3, PlatEnfant p4)
    {
        System.out.println("=== test2_AfficherPlats");
        if(trace)
        {
            System.out.print(p1);
            System.out.print(p2);
            System.out.print(p3);
            System.out.print(p4);
            System.out.print("\n");
        }
    }

    private void test3(boolean trace, Menu menu, PlatAuMenu p1, PlatAuMenu p2, PlatSante p3, PlatEnfant p4) {
        System.out.println("=== test3_AfficherMenu");
        if(trace)
        {
            System.out.println(menu);

            System.out.println("Ajout des plats au menu");
            menu.ajoute(p1);
            menu.ajoute(p2);
            menu.ajoute(p3);
            menu.ajoute(p4);

            System.out.println("Nouveau menu : \n" + menu + "\n");
        }
    }

    private void test4(boolean trace, FactureController facture, Menu menu) throws MenuException, FactureException {
        System.out.println("=== test4_AfficherFacture");
        if(trace)
        {
            System.out.println("Facture avant ajout des plats choisis");
            System.out.println(facture.toString());

            System.out.println("Ajout des plats choisis à la facture ");

            PlatChoisi platChoisi = new PlatChoisi(menu.platCourant(), 2);
            facture.ajoutePlat(platChoisi);

            menu.positionSuivante();
            platChoisi = new PlatChoisi(menu.platCourant(),1);
            facture.ajoutePlat(platChoisi);

            menu.positionSuivante();
            platChoisi = new PlatChoisi(menu.platCourant(),3);
            facture.ajoutePlat(platChoisi);

            menu.positionSuivante();
            platChoisi = new PlatChoisi(menu.platCourant(),4);
            facture.ajoutePlat(platChoisi);

            System.out.println("Nouvelle facture : \n" + facture + "\n");
        }
    }

    private void test5(boolean trace, FactureController facture) throws FactureException {
        System.out.println("=== test5_PayerFacture");
        if(trace)
        {
            System.out.println("Etat de la facture : " + facture.getEtat());

            facture.fermer();
            System.out.println("Etat de la facture : " + facture.getEtat());

            facture.payer();
            System.out.println("Etat de la facture : " + facture.getEtat());

            System.out.println("Génération de la facture:");
            facture.printFacture();
        }
    }
}
