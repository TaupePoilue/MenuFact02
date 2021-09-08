package menufact.plats;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PlatSante implements PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private double kcal;
    private double chol;
    private double gras;
    public HashMap<Ingredient, Integer> recetteTable = new HashMap<Ingredient, Integer>();

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {

        this.code = code;
        this.description = description;
        this.prix = prix;
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }
    public void CreerPlat(){}

    public PlatSante() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} {" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
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

    public double getKcal() { return kcal; }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}
