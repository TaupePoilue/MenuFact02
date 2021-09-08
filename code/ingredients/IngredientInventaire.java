package ingredients;

import java.util.*;
import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private IngredientInventaire ingredientInventaire;
    private int quantite;
    public Hashtable<Ingredient, Integer> itemsTable = new Hashtable<Ingredient, Integer>();

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
        Set set = itemsTable.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + " || Quantité: ");
            System.out.println(me.getValue());

        }
        return "FIN INVENTAIRE";
    }
}
