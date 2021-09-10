package menufact.plats;

import ingredients.*;
import menufact.plats.EtatPlat.PlatEnPreparation;
import menufact.plats.EtatPlat.PlatImpossibleAPreparer;
import menufact.plats.EtatPlat.PlatServi;
import menufact.plats.EtatPlat.PlatTermine;
import menufact.plats.exceptions.PlatException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlat {
    static PlatFactory platFactory;
    static Fruit i1;
    static PlatAuMenu p1;
    PlatChoisi platChoisi;

    @BeforeAll
    public static void setUp(){
        platFactory = new PlatFactory();

        i1 = new Fruit("Banane", "Jaune", new Solide());

        p1 = platFactory.creerPlatRegulier(0, "PlatRegulier1", 10);

        p1.ajoutIngredientRecette(i1, 5);

        try {
            IngredientInventaire.getInstance().setQuantite(i1, 5);
        }catch (Exception e)
        {
            System.out.println("Exception IngredientInventaire: " + e.getMessage());
        }
    }

    @BeforeEach
    public void  testSetUp(){
        platChoisi = new PlatChoisi(p1, 5);
    }

    @Test
    public void test1_creerPlatRegulier(){
        assertAll(() -> platFactory.creerPlatRegulier(0, "PlatRegulier1", 10));
    }

    @Test
    public void test2_creerPlatSante(){
        assertAll(() -> platFactory.creerPlatSante(0, "PlatSante1", 10, 10, 10, 10));
    }

    @Test
    public void test3_creerPlatEnfant(){
        assertAll(() -> platFactory.creerPlatEnfant(0, "PlatEnfant1", 10, 10));
    }

    @Test
    public void test4_platCommanderAPlatEnPreparation(){
        assertAll(platChoisi::preparer);
    }

    @Test
    public void test5_platCommanderAPlatTerminer(){
        assertThrows(Exception.class, platChoisi::terminer);
    }

    @Test
    public void test6_platCommanderAPlatServi(){
        assertThrows(Exception.class, platChoisi::servir);
    }

    @Test
    public void test7_platEnPreparationAPlatTerminer(){
        platChoisi.changerEtat(new PlatEnPreparation(platChoisi));
        assertAll(platChoisi::terminer);
    }

    @Test
    public void test8_platEnPreparationAPlatServi(){
        platChoisi.changerEtat(new PlatEnPreparation(platChoisi));
        assertThrows(PlatException.class, platChoisi::servir);
    }

    @Test
    public void test9_platTerminerAPlatServi(){
        platChoisi.changerEtat(new PlatTermine(platChoisi));
        assertAll(platChoisi::servir);
    }

    @Test
    public void test10_platTerminerAPlatEnPreparation(){
        platChoisi.changerEtat(new PlatTermine(platChoisi));
        assertThrows(PlatException.class, platChoisi::preparer);
    }

    @Test
    public void test11_platServiAPlatEnPreparation(){
        platChoisi.changerEtat(new PlatServi(platChoisi));
        assertThrows(PlatException.class, platChoisi::preparer);
    }

    @Test
    public void test12_platServiAPlatTermine(){
        platChoisi.changerEtat(new PlatServi(platChoisi));
        assertThrows(PlatException.class, platChoisi::terminer);
    }

    @Test
    public void test13_creerUnPlatImpossible(){
        platChoisi.setQuantite(10);
        assertEquals(PlatImpossibleAPreparer.class, platChoisi.getEtat().getClass());
    }
}
