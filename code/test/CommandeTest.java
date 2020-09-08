package test;

import ingredients.IngredientInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.cuisine.Commande;
import menufact.cuisine.Cuisine;
import menufact.cuisine.EtatErreur;
import menufact.cuisine.exceptions.InventaireException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Test;
import java.util.ArrayList;

public class CommandeTest {
    @Test
    public void CommandeVide() throws Exception{
        Commande commande = new Commande();

        if(commande.getEtat() == null || commande.getPlatsChoisi() != null){throw new Exception("Erreur dans le constructeur de base");}
    }

    @Test
    public void CommandeNonVide() throws Exception{
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        IngredientInventaire ingredient2 = new IngredientInventaire("pomme", "description2", TypeIngredient.FRUIT, 5);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
        p1.setIngredientInventaire(ingredients);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<PlatChoisi>();
        platsChoisi.add(pC);

        Commande commande = new Commande(platsChoisi);

        if(commande.getEtat() == null || commande.getPlatsChoisi() == null){throw new Exception("Erreur dans le constructeur avec paramètres");}
    }

    @Test
    public void PoursuivreCommande() throws InventaireException, IngredientException {
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        IngredientInventaire ingredient2 = new IngredientInventaire("pomme", "description2", TypeIngredient.FRUIT, 5);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        Cuisine cuisine = Cuisine.CreerCuisine(ingredients);

        PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50);
        p1.setIngredientInventaire(ingredients);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        Commande commande = new Commande(platsChoisi);
        commande.PoursuivreCommande();
        if(commande.getEtat().getClass() == EtatErreur.class){throw new InventaireException("Erreur dans l'inventaire de la cuisine");}

        /*---*/

        cuisine = Cuisine.CreerCuisine(ingredients);
        ArrayList<IngredientInventaire> ingredients2 = new ArrayList<>();
        IngredientInventaire ingredient3 = new IngredientInventaire("tomate", "description3", TypeIngredient.EPICE, 10);
        ingredients2.add(ingredient1);
        ingredients2.add(ingredient3);

        PlatAuMenu p2 = new PlatAuMenu(0, "Frites sauce", 11.50);
        p2.setIngredientInventaire(ingredients2);
        PlatChoisi pC2 = new PlatChoisi(p2, 1);
        ArrayList<PlatChoisi> platsChoisi2 = new ArrayList<>();
        platsChoisi2.add(pC2);

        Commande commande2 = new Commande(platsChoisi2);

        commande2.PoursuivreCommande();
        if(commande2.getEtat().getClass() != EtatErreur.class){throw new InventaireException("Erreur dans la reconnaissance des ingrédients");}

        /*---*/

        cuisine = Cuisine.CreerCuisine(ingredients);
        ArrayList<IngredientInventaire> ingredients3 = new ArrayList<>();
        IngredientInventaire ingredient4 = new IngredientInventaire("patate", "description3", TypeIngredient.LEGUME, 10);
        ingredients3.add(ingredient4);
        ingredients3.add(ingredient2);

        PlatAuMenu p3 = new PlatAuMenu(0, "Frites sauce", 11.50);
        p3.setIngredientInventaire(ingredients3);
        PlatChoisi pC3 = new PlatChoisi(p3, 1);
        ArrayList<PlatChoisi> platsChoisi3 = new ArrayList<>();
        platsChoisi3.add(pC3);

        Commande commande3 = new Commande(platsChoisi3);

        commande3.PoursuivreCommande();
        if(commande3.getEtat().getClass() != EtatErreur.class){throw new InventaireException("Erreur dans le calcul des ingrédients");}
    }
}
