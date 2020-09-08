package test;

import ingredients.IngredientInventaire;
import ingredients.TypeIngredient;
import menufact.cuisine.*;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import org.junit.Test;

import java.util.ArrayList;

public class CommandeEtatTest {
    @Test
    public void EtatCommande() throws Exception{
        ArrayList<IngredientInventaire> ingredients = new ArrayList<>();
        IngredientInventaire ingredient1 = new IngredientInventaire("patate", "description1", TypeIngredient.LEGUME, 20);
        ingredients.add(ingredient1);
        Cuisine cuisine = Cuisine.CreerCuisine(ingredients);

        PlatAuMenu p1 = new PlatAuMenu(0, "description", 1.60);
        p1.setIngredientInventaire(ingredients);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        CommandeEtat etatCommande = new EtatCommande();
        etatCommande = etatCommande.prochainEtat(platsChoisi);
        if(etatCommande.getClass() != EtatEnPreparation.class && etatCommande.getClass() != EtatErreur.class){throw new Exception("Erreur dans la transition d'état");}
    }

    @Test
    public void EtatEnPreparation() throws Exception{
        PlatAuMenu p1 = new PlatAuMenu(0, "description", 1.60);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        CommandeEtat etatCommande = new EtatEnPreparation();
        etatCommande = etatCommande.prochainEtat(platsChoisi);
        if(etatCommande.getClass() != EtatTerminer.class){throw new Exception("Erreur dans la transition d'état");}
    }

    @Test
    public void EtatTerminer() throws Exception{
        PlatAuMenu p1 = new PlatAuMenu(0, "description", 1.60);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        CommandeEtat etatCommande = new EtatTerminer();
        etatCommande = etatCommande.prochainEtat(platsChoisi);
        if(etatCommande.getClass() != EtatServi.class){throw new Exception("Erreur dans la transition d'état");}
    }

    @Test
    public void EtatServi() throws Exception{
        PlatAuMenu p1 = new PlatAuMenu(0, "description", 1.60);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        CommandeEtat etatCommande = new EtatServi();
        etatCommande = etatCommande.prochainEtat(platsChoisi);
        if(etatCommande.getClass() != EtatServi.class){throw new Exception("Erreur dans la transition d'état");}
    }

    @Test
    public void EtatErreur() throws Exception{
        PlatAuMenu p1 = new PlatAuMenu(0, "description", 1.60);
        PlatChoisi pC = new PlatChoisi(p1, 1);
        ArrayList<PlatChoisi> platsChoisi = new ArrayList<>();
        platsChoisi.add(pC);

        CommandeEtat etatCommande = new EtatErreur();
        etatCommande = etatCommande.prochainEtat(platsChoisi);
        if(etatCommande.getClass() != EtatErreur.class){throw new Exception("Erreur dans la transition d'état");}
    }
}
