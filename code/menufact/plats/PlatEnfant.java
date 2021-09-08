package menufact.plats;

import ingredients.Ingredient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PlatEnfant implements PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private double proportion;
    public HashMap<Ingredient, Integer> recetteTable = new HashMap<Ingredient, Integer>();

    public PlatEnfant() {
    }
    public void CreerPlat(){}

    public PlatEnfant(int code, String description, double prix, double proportion) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.proportion = proportion;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getProportion() {
        return proportion;
    }

    public void ajoutIngredientRecette(Ingredient ingredient,int quantite){
        this.recetteTable.put(ingredient, quantite);
    }

    public String printRecette() {
        System.out.println("Recette: ");
        Set set = recetteTable.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + " || Quantité: ");
            System.out.println(me.getValue());

        }
        return "FIN RECETTE";
    }

    public HashMap getRecette() {
        return recetteTable;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} {"  +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }
}
