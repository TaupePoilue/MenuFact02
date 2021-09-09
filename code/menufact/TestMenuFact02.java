package menufact;

import ingredients.*;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatRegulier;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;

public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;

        TestMenuFact02 t = new TestMenuFact02();

        PlatRegulier p1 = new PlatRegulier(0,"PlatAuMenu0",10);
        PlatRegulier p2 = new PlatRegulier(1,"PlatAuMenu1",20);
        PlatRegulier p3 = new PlatRegulier(2,"PlatAuMenu2",30);
        PlatRegulier p4 = new PlatRegulier(3,"PlatAuMenu3",40);
        PlatRegulier p5 = new PlatRegulier(4,"PlatAuMenu4",50);


        PlatSante ps1 = new PlatSante(10,"PlatSante0",10,11,11,11);
        PlatSante ps2 = new PlatSante(11,"PlatSante1",20,11,11,11);
        PlatSante ps3 = new PlatSante(12,"PlatSante2",30,11,11,11);
        PlatSante ps4 = new PlatSante(13,"PlatSante3",40,11,11,11);
        PlatSante ps5 = new PlatSante(14,"PlatSante4",50,11,11,11);


        Menu m1 = Menu.getInstance("menufact.Menu 1");
        Menu m2 = Menu.getInstance("menufact.Menu 2");

        Facture f1 = new Facture("Ma facture");

        Client c1 = new Client(1,"Mr Client","1234567890");

        t.test13_CreerInventaire();

        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
        t. test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);

        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);


        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(f1, m1);
        } catch (FactureException e) {
            System.out.println(e.getMessage());
        }


        t.test8_AjouterClientFacture(f1, c1);

        System.out.println("\n===TEST FACTURE OUVERTE===");

        try {
            t.test8_AjouterPlatsFacture(f1, m1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        t.test10_SelectionnerUnPlat(1, f1);
        t.test12_RetirerPlat(f1);
        System.out.println(f1.genererFacture());

        System.out.println("\n===TEST FACTURE FERMER===");

        try {
            t.test14_AjouterRecette(p1,"banane",100);
            t.test8_AjouterPlatsFacture(f1, m1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        try {
            f1.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        t.test11_FermerFacture(f1);
        t.test10_SelectionnerUnPlat(1, f1);
        t.test12_RetirerPlat(f1);
        System.out.println(f1.genererFacture());

        System.out.println("\n===TEST FACTURE PAYEE===");

        t.test9_PayerFacture(f1);
        t.test10_SelectionnerUnPlat(1, f1);
        t.test12_RetirerPlat(f1);

        try {
            t.test8_AjouterPlatsFacture(f1, m1,1);
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        try {
            f1.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(f1.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatRegulier p1, PlatRegulier p2,
                                          PlatRegulier p3, PlatRegulier p4, PlatRegulier p5)
    {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, PlatSante ps1, PlatSante ps2,
                                               PlatSante ps3, PlatSante ps4, PlatSante ps5)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
                                        PlatRegulier p1, PlatRegulier p2,
                                        PlatSante ps1, PlatSante ps2,
                                        Menu m2,
                                        PlatRegulier p3, PlatRegulier p4,
                                        PlatSante ps3, PlatSante ps4)
    {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
    {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
    {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException
    {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }

        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1,Client c1) {
        System.out.println("===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }
    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException,FactureException
    {
        System.out.println("===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.positionSuivante();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5);
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1)
    {
        System.out.println("===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(f1.genererFacture());

        try {
            f1.payer();
        }catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("Apres avoir paye la facture");
        System.out.println(f1.genererFacture());
    }

    private void test10_SelectionnerUnPlat(int index, Facture f)
    {
        System.out.println("===test10_SelectionnerUnPlat");

        try {
            f.selectionnerPlat(index);
        }catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }
    }

    private void test11_FermerFacture(Facture f1)
    {
        System.out.println("===test11_FermerFacture");

        System.out.println("Avant fermer la facture");
        System.out.println(f1.genererFacture());

        try {
            f1.fermer();
        }catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }

        System.out.println("Apres avoir fermer la facture");
        System.out.println(f1.genererFacture());
    }

    private void test12_RetirerPlat(Facture f1){
        System.out.println("===test12_RetirerPlat");

        try{
            System.out.println("Avant retirer plat");
            System.out.println(f1);
            f1.retirerPlat();
            System.out.println("Apres retirer plat");
            System.out.println(f1);
        }catch (FactureException fe){
            System.out.println(fe.getMessage());
        }
    }

    private void test13_CreerInventaire(){
        try{
            System.out.println("===test13_CreerInventaire");
            Fruit banane = new Fruit("Banane", "Jaune", new Solide());
            Fruit pomme = new Fruit("Pomme", "Rouge", new Solide());
            Fruit ananas = new Fruit("Ananas", "Jaune", new Solide());
            Fruit jusDePomme = new Fruit("Jus de Pomme", "Bio", new Liquide());
            Fruit compotteDePomme = new Fruit("Compotte de Pomme", "Maison", new Liquide());

            Viande poulet = new Viande("Poulet","Poitrine", new Solide());
            Viande boeuf = new Viande("Boeuf","Cote", new Solide());
            Viande bouillontDePoulet = new Viande("Bouillon de Poulet","Clair", new Liquide());
            Viande bouillontDeBoeuf = new Viande("Bouillon de Boeuf","Fonce", new Liquide());

            Legume poivron = new Legume("Poivron","Vert", new Solide());
            Legume tomate = new Legume("Tomate","Italienne", new Solide());
            Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
            Legume huileOlive = new Legume("Huile d'olive","Extra Vierge", new Liquide());

            Laitier beurre = new Laitier("Beurre","Demi-Sel", new Solide());
            Laitier fromage = new Laitier("Fromage","Suisse", new Solide());
            Laitier lait = new Laitier("Lait","2%", new Liquide());
            Laitier creme = new Laitier("Creme","15%", new Liquide());

            Epice sel = new Epice("Sel","De Mer", new Solide());
            Epice poivre = new Epice("Poivre","Noir", new Solide());
            Epice tabasco = new Epice("Tabasco","Epice", new Liquide());
            Epice sauceSoja = new Epice("Sauce Soja","Du Quebec", new Liquide());

            sel.setDescription("Kasher");
            sel.setNom("Demi-Sel");
            sel.setEtat(new Liquide());
            sel.setTypeIngredient(TypeIngredient.FRUIT);

            sel = new Epice("Sel","De Mer", new Solide());

            IngredientInventaire storage = IngredientInventaire.getInstance();
            //FRUIT
            storage.setQuantite(banane, 20);
            storage.setQuantite(pomme, 22);
            storage.setQuantite(ananas, 20);
            storage.setQuantite(jusDePomme, 22);
            storage.setQuantite(compotteDePomme, 20);
            //VIANDE
            storage.setQuantite(poulet, 22);
            storage.setQuantite(boeuf, 20);
            storage.setQuantite(bouillontDePoulet, 22);
            storage.setQuantite(bouillontDeBoeuf, 20);
            //LEGUME
            storage.setQuantite(poivron, 22);
            storage.setQuantite(tomate, 20);
            storage.setQuantite(sauceTomate, 22);
            storage.setQuantite(sauceSoja, 20);
            //LAITIER
            storage.setQuantite(beurre, 22);
            storage.setQuantite(fromage, 20);
            storage.setQuantite(lait, 22);
            storage.setQuantite(creme, 20);
            //EPICE
            storage.setQuantite(sel, 22);
            storage.setQuantite(poivre, 20);
            storage.setQuantite(tabasco, 22);
            storage.setQuantite(sauceSoja, 20);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void test14_AjouterRecette(PlatAuMenu platAuMenu, String ingredient, int quantite){
        System.out.println("===test14_AjouterRecette");
        platAuMenu.ajoutIngredientRecetteString(ingredient, quantite);

    }
}
