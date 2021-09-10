package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMenu {

    private static Menu m1;
    private static PlatAuMenu p1;
    private static PlatAuMenu ps1;
    private static PlatAuMenu pe1;

    @BeforeAll
    public static void setup(){
        PlatFactory platFactory = new PlatFactory();

        p1 = platFactory.creerPlatRegulier(0, "Plat regulier 1", 10);
        ps1 = platFactory.creerPlatSante(1, "Plat sante 1", 15, 10, 10,10);
        pe1 = platFactory.creerPlatEnfant(2, "Plat enfant 1", 20, 10);

        m1 = Menu.getInstance("Menu 1");

        m1.ajoute(p1);
        m1.ajoute(ps1);
        m1.ajoute(pe1);
    }

    @Test
    void test1_ajouterPlatSanteeAuMenu(){
        assert(m1.ajoute(ps1));
    }

    @Test
    void test2_ajouterPlatEnfantAuMenu(){
        assert(m1.ajoute(pe1));
    }

    @Test
    void test3_ajouterPlatRegulieAuMenu(){
        assert(m1.ajoute(p1));
    }

    @Test
    void test4_positionPrecedenteLorsquePositionCouranteEst0(){
        m1.position(0);
        assertThrows(MenuException.class, () -> m1.positionPrecedente());
    }

    @Test
    void test5_prochainePositionLorsquePositionCouranteEst0(){
        assertAll(() -> m1.positionSuivante());
    }

    @Test
    void test6_valeurPositionCourante(){
        m1.position(0);
        assertEquals(p1, m1.platCourant());
    }

    @Test
    void test7_positionSuivantALaFinDuMenu(){
        m1.position(2);
        assertThrows(MenuException.class, () -> m1.positionSuivante());
    }

    @Test
    void test8_utilisationNormalDePosition(){

        m1.position(2);

        assertEquals(pe1, m1.platCourant());
    }

    @Test
    void test9_positionAvecValeurPlusPetiteQue0(){
        assertThrows(MenuException.class, () -> m1.position(-1));
    }

    @Test
    void test10_positionAvecValeurPlusEleverQueLeNombreDePlatAuMenu(){
        m1.ajoute(p1);
        m1.ajoute(ps1);
        m1.ajoute(pe1);

        assertThrows(MenuException.class, () -> m1.position(5));
    }

    @Test
    void test11_uneSeuleInstanceDeMenu(){
        Menu m2 = Menu.getInstance("Menu2");

        m1.ajoute(p1);

        assertEquals(m1, m2);
    }
}
