package menufact.plats;

import ingredients.Fruit;
import ingredients.IngredientInventaire;
import ingredients.Liquide;
import ingredients.Solide;

public class TestPlat {
    public static void main(String[] args) {

        try {
            String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
            System.out.println("===package menufact.plats debut test UNITAIRE==="+ newLine);
            System.out.println("===Creation de 3 plats===");

            PlatFactory platFactory = new PlatFactory();
            PlatAuMenu plat1 = platFactory.creerPlatRegulier(1,"Frite",12.50);
            System.out.println("plat1: " + plat1.toString());
            PlatAuMenu plat2 = platFactory.creerPlatEnfant(2,"Tomate",12.50,0.5);
            System.out.println("plat2: " + plat2.toString());
            PlatAuMenu plat3 = platFactory.creerPlatSante(3,"Apple",12.50,50,40,10);
            System.out.println("plat3: " + plat3.toString());
            System.out.println();
            //CODE
            System.out.println("===getCode des 3 plats===");
            System.out.println("plat1 Code: " + plat1.getCode());
            System.out.println("plat2 Code: " + plat2.getCode());
            System.out.println("plat3 Code: " + plat3.getCode());
            System.out.println();
            System.out.println("===setCode des 3 plats===");
            plat1.setCode(3);
            plat2.setCode(2);
            plat3.setCode(1);
            System.out.println("plat1 Code: " + plat1.getCode());
            System.out.println("plat2 Code: " + plat2.getCode());
            System.out.println("plat3 Code: " + plat3.getCode());
            System.out.println();
            //DESCRIPTION
            System.out.println("===getDescription des 3 plats===");
            System.out.println("plat1 Description: " + plat1.getDescription());
            System.out.println("plat2 Description: " + plat2.getDescription());
            System.out.println("plat3 Description: " + plat3.getDescription());
            System.out.println();
            System.out.println("===setDescription des 3 plats===");
            plat1.setDescription("Banane et Pomme");
            plat2.setDescription("Diner");
            plat3.setDescription("Souper");
            System.out.println("plat1 Description: " + plat1.getDescription());
            System.out.println("plat2 Description: " + plat2.getDescription());
            System.out.println("plat3 Description: " + plat3.getDescription());
            //PRIX
            System.out.println();
            System.out.println("===getPrix des 3 plats===");
            System.out.println("plat1 Prix: " + plat1.getPrix());
            System.out.println("plat2 Prix: " + plat2.getPrix());
            System.out.println("plat3 Prix: " + plat3.getPrix());
            System.out.println();
            System.out.println("===setPrix des 3 plats===");
            plat1.setPrix(2.55);
            plat2.setPrix(3.67);
            plat3.setPrix(6.66);
            System.out.println("plat1 Prix: " + plat1.getPrix());
            System.out.println("plat2 Prix: " + plat2.getPrix());
            System.out.println("plat3 Prix: " + plat3.getPrix());
            System.out.println();
            System.out.println("===Impression des 3 plats===");
            System.out.println("plat1: " + plat1.toString());
            System.out.println("plat2: " + plat2.toString());
            System.out.println("plat3: " + plat3.toString());
            System.out.println();
            System.out.println("===Test RECETTE==="+ newLine);
            Fruit banane = new Fruit("Banane", "Jaune", new Solide());
            Fruit pomme = new Fruit("Pomme", "Rouge", new Solide());
            Fruit ananas = new Fruit("Ananas", "Jaune", new Solide());
            Fruit jusDePomme = new Fruit("Jus de Pomme", "Bio", new Liquide());

            System.out.println("===Creation recette plat1===");
            plat1.ajoutIngredientRecette(banane,3);
            plat1.ajoutIngredientRecette(pomme,2);
            System.out.println("plat1: " + plat1.toString());
            plat1.printRecette();
            System.out.println();
            System.out.println("===Changement 5 pommes===");
            plat1.ajoutIngredientRecette(pomme,5);
            plat1.printRecette();
            System.out.println();
            System.out.println("===Ajout 5 ananas===");
            plat1.ajoutIngredientRecette(ananas,5);
            plat1.printRecette();
            System.out.println();

            System.out.println("===Creation Inventaire===");
            IngredientInventaire storage = IngredientInventaire.getInstance();
            storage.setQuantite(banane, 20);
            storage.setQuantite(pomme, 22);
            storage.setQuantite(ananas, 20);
            storage.setQuantite(jusDePomme, 0);
            System.out.println(storage.toString());
            System.out.println();

            System.out.println("===Verifier que l'on peut faire la recette===");
            System.out.println("Nous avons les ingredients: " + storage.verifierInventaire(plat1.getRecette()));
            System.out.println("===Faire la recette (Soustraire)===");
            storage.soustraireQuantite(plat1.getRecette());
            System.out.println(storage.toString());
            System.out.println();

            System.out.println("===Ajout 1 jusDePomme===");
            plat1.ajoutIngredientRecette(jusDePomme,1);
            plat1.printRecette();
            System.out.println();
            System.out.println("===Verifier que l'on peut faire la recette===");
            System.out.println("Nous avons les ingredients: " + storage.verifierInventaire(plat1.getRecette()));









        } catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("===TEST ETAT PLATCHOISI=== \n");

        TestPlat tp = new TestPlat();

        PlatRegulier p1 = new PlatRegulier();
        PlatChoisi platChoisi = new PlatChoisi(p1, 2);

        try {
            System.out.println("Test1 - Preparer plat");
            tp.test1_PreparerPlatChoisi(platChoisi);
            System.out.println("REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Test2 - Terminer plat");
            tp.test2_TerminerPlatChoisi(platChoisi);
            System.out.println("REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Test3 - Servir plat");
            tp.test3_ServirPlatChoisi(platChoisi);
            System.out.println("REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void test1_PreparerPlatChoisi(PlatChoisi p) throws Exception{
        p.preparer();
        if(p.getClass().toString().equals("PlatEnPreparation")){
            throw new Exception("Test1 - ECHEC");
        }
    }

    public void test2_TerminerPlatChoisi(PlatChoisi p) throws Exception{
        p.terminer();
        if(p.getClass().toString().equals("PlatTermine")){
            throw new Exception("Test2 - ECHEC");
        }
    }

    public void test3_ServirPlatChoisi(PlatChoisi p) throws Exception{
        p.servir();
        if(p.getClass().toString().equals("PlatServi")){
            throw new Exception("Test3 - ECHEC");
        }
    }
}
