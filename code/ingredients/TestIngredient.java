package ingredients;

import java.util.*;

public class TestIngredient {
    public static void main(String[] args) {

        try {
            String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

            System.out.println("===package ingredients debut test UNITAIRE===");

            System.out.println(newLine + "=== FRUIT CREATION ===");
            Fruit banane = new Fruit("Banane", "Jaune", new Solide());
            Fruit pomme = new Fruit("Pomme", "Rouge", new Solide());
            Fruit ananas = new Fruit("Ananas", "Jaune", new Solide());
            Fruit jusDePomme = new Fruit("Jus de Pomme", "Bio", new Liquide());
            Fruit compotteDePomme = new Fruit("Compotte de Pomme", "Maison", new Liquide());

            System.out.println(newLine + "=== FRUIT toString ===");
            System.out.println("TestIngredient(banane): " + banane.toString());
            System.out.println("TestIngredient(pomme): " + pomme.toString());
            System.out.println("TestIngredient(ananas): " + ananas.toString());
            System.out.println("TestIngredient(jusDePomme): " + jusDePomme.toString());
            System.out.println("TestIngredient(compotteDePomme): " + compotteDePomme.toString());

            System.out.println(newLine + "=== VIANDE CREATION ===");
            Viande poulet = new Viande("Poulet","Poitrine", new Solide());
            Viande boeuf = new Viande("Boeuf","Cote", new Solide());
            Viande bouillontDePoulet = new Viande("Bouillon de Poulet","Clair", new Liquide());
            Viande bouillontDeBoeuf = new Viande("Bouillon de Boeuf","Fonce", new Liquide());

            System.out.println(newLine + "=== VIANDE toString ===");
            System.out.println("TestIngredient(poulet): " + poulet.toString());
            System.out.println("TestIngredient(boeuf): " + boeuf.toString());
            System.out.println("TestIngredient(bouillontDePoulet): " + bouillontDePoulet.toString());
            System.out.println("TestIngredient(bouillontDeBoeuf): " + bouillontDeBoeuf.toString());

            System.out.println(newLine + "=== LEGUME CREATION ===");
            Legume poivron = new Legume("Poivron","Vert", new Solide());
            Legume tomate = new Legume("Tomate","Italienne", new Solide());
            Legume sauceTomate = new Legume("Sauce Tomate","Maison", new Liquide());
            Legume huileOlive = new Legume("Huile d'olive","Extra Vierge", new Liquide());

            System.out.println(newLine + "=== LEGUME toString ===");
            System.out.println("TestIngredient(poivron): " + poivron.toString());
            System.out.println("TestIngredient(tomate): " + tomate.toString());
            System.out.println("TestIngredient(sauceTomate): " + sauceTomate.toString());
            System.out.println("TestIngredient(huileOlive): " + huileOlive.toString());

            System.out.println(newLine + "=== LAITIER CREATION ===");
            Laitier beurre = new Laitier("Beurre","Demi-Sel", new Solide());
            Laitier fromage = new Laitier("Fromage","Suisse", new Solide());
            Laitier lait = new Laitier("Lait","2%", new Liquide());
            Laitier creme = new Laitier("Creme","15%", new Liquide());

            System.out.println(newLine + "=== LAITIER toString ===");
            System.out.println("TestIngredient(beurre): " + beurre.toString());
            System.out.println("TestIngredient(fromage): " + fromage.toString());
            System.out.println("TestIngredient(lait): " + lait.toString());
            System.out.println("TestIngredient(creme): " + creme.toString());

            System.out.println(newLine + "=== EPICE CREATION ===");
            Epice sel = new Epice("Sel","De Mer", new Solide());
            Epice poivre = new Epice("Poivre","Noir", new Solide());
            Epice tabasco = new Epice("Tabasco","Epice", new Liquide());
            Epice sauceSoja = new Epice("Sauce Soja","Du Quebec", new Liquide());

            System.out.println(newLine + "=== EPICE toString ===");
            System.out.println("TestIngredient(sel): " + sel.toString());
            System.out.println("TestIngredient(poivre): " + poivre.toString());
            System.out.println("TestIngredient(tabasco): " + tabasco.toString());
            System.out.println("TestIngredient(sauceSoja): " + sauceSoja.toString());

            System.out.println(newLine + "=== INGREDIENT Set & Get ===");
            sel.setDescription("Kasher");
            sel.setNom("Demi-Sel");
            sel.setEtat(new Liquide());
            sel.setTypeIngredient(TypeIngredient.FRUIT);
            System.out.println("TestIngredient(sel): " + sel.toString());

            System.out.println(newLine + "=== INGREDIENT Delete ===");
            sel = new Epice("Sel","De Mer", new Solide());
            System.out.println("TestIngredient(sel_New): " + sel.toString());

            System.out.println(newLine + "=== INVENTAIRE HASHTABLE ===");
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

            System.out.println(storage.toString());

            System.out.println(newLine + "=== INVENTAIRE HASHTABLE: Changer sel ===");
            System.out.println(storage.getQuantite(banane));
            sel.setDescription("Kasher");
            sel.setNom("Demi-Sel");
            sel.setEtat(new Liquide());
            sel.setTypeIngredient(TypeIngredient.FRUIT);

            System.out.println(storage.toString());






        } catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
