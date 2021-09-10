package ingredients;

import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TestIngredient {

    @Test
    public void test1_ajouterUnFruitSolideAInventaire(){
        Fruit banane = new Fruit("Banane", "Jaune", new Solide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(banane, 1));
    }

    @Test
    public void test2_ajouterUnFruitLiquideAInventaire(){
        Fruit jusDePomme = new Fruit("Jus de Pomme", "Bio", new Liquide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(jusDePomme, 1));
    }

    @Test
    public void test3_ajouterUnEpiceSolideAInventaire(){
        Epice sel = new Epice("Sel","De Mer", new Solide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(sel, 1));
    }

    @Test
    public void test4_ajouterUnEpiceLiquideAInventaire(){
        Epice tabasco = new Epice("Tabasco","Epice", new Liquide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(tabasco, 1));
    }

    @Test
    public void test5_ajouterLaitierSolideAInventaire(){
        Laitier fromage = new Laitier("Fromage","Suisse", new Solide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(fromage, 1));
    }

    @Test
    public void test6_ajouterLaitierLiquideAInventaire(){
        Laitier lait = new Laitier("Lait","2%", new Liquide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(lait, 1));
    }

    @Test
    public void test7_ajouterViandeSolideAInventaire(){
        Viande boeuf = new Viande("Boeuf","Cote", new Solide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(boeuf, 1));
    }

    @Test
    public void test8_ajouterViandeLiquideAInventaire(){
        Viande bouillontDePoulet = new Viande("Bouillon de Poulet","Clair", new Liquide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(bouillontDePoulet, 1));
    }

    @Test
    public void test9_ajouterLegumeSolideAInventaire(){
        Legume tomate = new Legume("Tomate","Italienne", new Solide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(tomate, 1));
    }

    @Test
    public void test10_ajouterLegumeLiquideAInventaire(){
        Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
        assertAll(() -> IngredientInventaire.getInstance().setQuantite(sauceTomate, 1));
    }

    @Test
    public void test11_ajouterAUnIngredientDejaEnInventaire(){
        Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
        try {
            IngredientInventaire.getInstance().setQuantite(sauceTomate, 1);
        }
        catch (IngredientException ie){}
        assertEquals(2, IngredientInventaire.getInstance().getQuantite(sauceTomate));
    }

    @Test
    public void test12_verifierRecettePossible(){
        Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
        HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
        try {
            IngredientInventaire.getInstance().setQuantite(sauceTomate, 1);
        }
        catch (IngredientException ie){}
        recette.put(sauceTomate, 1);
        assertTrue(IngredientInventaire.getInstance().verifierInventaire(recette));
    }

    @Test
    public  void test13_verifierRecetteImpossible(){
        Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
        HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
        try {
            IngredientInventaire.getInstance().setQuantite(sauceTomate, 1);
        }
        catch (IngredientException ie){}
        recette.put(sauceTomate, 50);
        assertFalse(IngredientInventaire.getInstance().verifierInventaire(recette));
    }

    @Test
    public void test14_soustraireRecetteDeInventaire(){
        Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
        HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
        recette.put(sauceTomate, 1);
        try {
            IngredientInventaire.getInstance().setQuantite(sauceTomate, 1);
        }
        catch (IngredientException ie){}
        IngredientInventaire.getInstance().soustraireQuantite(recette);

        assertEquals(0, IngredientInventaire.getInstance().getQuantite(sauceTomate));
    }
}
