package ingredients;

import java.util.*;
import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private static IngredientInventaire ingredientInventaire = null;
    private int quantite;
    private HashMap<Ingredient, Integer> itemsTable = new HashMap<Ingredient, Integer>();

    private IngredientInventaire(){}

    public static IngredientInventaire getInstance(){
        if (ingredientInventaire == null){
            ingredientInventaire = new IngredientInventaire();
        }
        return ingredientInventaire;
    }

    public int getQuantite(Ingredient ingredient) {
        return itemsTable.get(ingredient);
    }

    public void setQuantite(Ingredient ingredient,int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.itemsTable.put(ingredient, quantite);
    }

    public String toString(){
        System.out.println("Inventaire: ");
        Set set = itemsTable.entrySet();
        Ingredient ingredientTest = new Ingredient();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + " || Quantité: ");
            ingredientTest = (Ingredient) me.getKey();
            System.out.println(me.getValue());

        }
        return "FIN INVENTAIRE";
    }
    public String soustraireQuantite(HashMap recette) {
        Set set1 = this.itemsTable.entrySet();
        Set set2 = recette.entrySet();
        // Get an iterator
        Iterator j = set2.iterator();
        // Display elements
        while(j.hasNext()) {
            Map.Entry map2 = (Map.Entry)j.next();
            Iterator i = set1.iterator();
            while(i.hasNext()) {
                Map.Entry map1 = (Map.Entry)i.next();
                if (map1.getKey().equals(map2.getKey())) {
                    int quantiteStorage = (Integer) map1.getValue();
                    int quantiteRecette = (Integer) map2.getValue();
                    map1.setValue(quantiteStorage - quantiteRecette);
                }
            }
        }
        return "FIN SOUSTRACTION";
    }

    public boolean verifierInventaire(HashMap recette) {
        Set set1 = this.itemsTable.entrySet();
        Set set2 = recette.entrySet();
        // Get an iterator
        Iterator j = set2.iterator();
        // Display elements
        while(j.hasNext()) {
            Map.Entry map2 = (Map.Entry)j.next();
            Iterator i = set1.iterator();
            while(i.hasNext()) {
                Map.Entry map1 = (Map.Entry)i.next();
                if (map1.getKey().equals(map2.getKey())) {
                    int quantiteStorage = (Integer) map1.getValue();
                    int quantiteRecette = (Integer) map2.getValue();
                    if ((quantiteStorage - quantiteRecette) < 0) {
                        return false;
                    };
                }
            }
        }
        return true;
    }
}
