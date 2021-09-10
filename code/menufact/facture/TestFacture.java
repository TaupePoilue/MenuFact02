package menufact.facture;

import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.Solide;
import menufact.Menu;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestFacture {
    static PlatAuMenu p1;
    static PlatAuMenu p2;
    Facture f1;

    @BeforeAll
    public static void classSetUp(){
        PlatFactory platFactory = new PlatFactory();

        Fruit i1 = new Fruit("Banane", "Jaune", new Solide());

        p1 = platFactory.creerPlatRegulier(0, "PlatRegulier1", 10);
        p2 = platFactory.creerPlatRegulier(0, "PlatRegulier2", 20);

        p1.ajoutIngredientRecette(i1, 1);

        try {
            IngredientInventaire.getInstance().setQuantite(i1, 5);
        }catch (Exception e)
        {
            System.out.println("Exception IngredientInventaire: " + e.getMessage());
        }

        Menu.getInstance("Menu1").ajoute(p1);
    }

    @BeforeEach
    public void testSetUp(){
        f1 = new Facture("Facture1");
    }

    @Test
    @DisplayName("Ajouter un plat qui est au menu devrait fonctionner")
    public void test1_ajouterUnPlat(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        assertAll(() -> f1.ajoutePlat(pc1));
    }

    @Test
    @DisplayName("Ajouter un plat qui n'est pas au menu ne devrait pas fonctionner")
    public void test2_ajouterUnPlatQuiNEstPasAuMenu(){
        PlatChoisi pc2 = new PlatChoisi(p2, 5);

        assertThrows(FactureException.class, () -> f1.ajoutePlat(pc2));
    }

    @Test
    @DisplayName("Impossibilite d'ajouter un plat s'il manque d'ingredient")
    public void test3_ajouterUnPlatAvecTropDIngredient(){
        PlatChoisi pc1 = new PlatChoisi(p1, 10);

        assertThrows(FactureException.class, () -> f1.ajoutePlat(pc1));
    }

    @Test
    public void test4_ouvrirUneFactureOuverte(){
        assertAll(() -> f1.ouvrir());
    }

    @Test
    public void test5_fermerUneFactureOuverte(){
        assertAll(() -> f1.fermer());
    }

    @Test
    public void test6_payerUneFactureOuverte(){
        assertAll(() -> f1.payer());
    }

    @Test
    public void test7_ouvrirUneFactureFermer(){
        assertAll(() -> {f1.fermer(); f1.ouvrir();});
    }

    @Test
    public void test8_fermerUneFactureFermer(){
        assertAll(() -> {f1.fermer(); f1.fermer();});
    }

    @Test
    public void test9_payerUneFactureFermer(){
        assertAll(() -> {f1.fermer(); f1.payer();});
    }

    @Test
    public void test10_ouvrirUneFacturePayer(){
        assertThrows(FactureException.class, () -> {f1.payer(); f1.ouvrir();});
    }

    @Test
    public void test11_fermerUneFacturePayer(){
        assertThrows(FactureException.class, () -> {f1.payer(); f1.ouvrir();});
    }

    @Test
    public void test12_payerUneFacturePayer(){
        assertThrows(FactureException.class, () -> {f1.payer(); f1.ouvrir();});
    }

    @Test
    public void test13_selectionnerUnPlat(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        assertAll(() -> {f1.ajoutePlat(pc1); f1.selectionnerPlat(0);});
    }

    @Test
    public void test14_selectionnerUnPlatAvecUnIndexTropGrand(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        assertAll(() -> {f1.ajoutePlat(pc1); f1.selectionnerPlat(5);});
    }

    @Test
    public void test15_retirerPlatCourant(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        try{
            f1.ajoutePlat(pc1);
            f1.selectionnerPlat(0);
        }catch (FactureException fe){}

        assertAll(f1::retirerPlat);
    }

    @Test
    public void test16_ajouteUnPlatAUneFactureFermer(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        try{
            f1.fermer();
        }catch (FactureException fe){}

        assertThrows(FactureException.class, () -> f1.ajoutePlat(pc1));
    }

    @Test
    public void test17_ajoutePlatAUneFacturePaye(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        try{
            f1.payer();
        }catch (FactureException fe){}

        assertThrows(FactureException.class, () -> f1.ajoutePlat(pc1));
    }

    @Test
    public void test18_selectionnerUnPlatDansUneFactureFermer(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        try{
            f1.ajoutePlat(pc1);
            f1.fermer();
        }catch (FactureException fe){}

        assertThrows(FactureException.class, () -> f1.selectionnerPlat(0));
    }

    @Test
    public void test19_selectionnerUnPlatDansUneFacturePaye(){
        PlatChoisi pc1 = new PlatChoisi(p1, 5);

        try{
            f1.ajoutePlat(pc1);
            f1.payer();
        }catch (FactureException fe){}

        assertThrows(FactureException.class, () -> f1.selectionnerPlat(0));
    }
}
