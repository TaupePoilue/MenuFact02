package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
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
    /**
     *
     * @return les caracteristique du plat sante en chaine de caractere
     */
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

    /**
     *
     * @return le code du plat
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code le code du plat
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return la description du plat en chaine de caractere
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description la description du du plat
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return le prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     *
     * @param prix le prix du plat
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void ajoutIngredientRecette(Ingredient ingredient,int quantite){
        this.recetteTable.put(ingredient, quantite);
    }

    /**
     *
     * @return la composition de la recette, donc l'ingredient suivit de sa quantite en chaine de caractere
     */
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

    /**
     *
     * @param ingredient l'ingredient sous forme de chaine de caractere a ajouter dans la recette
     * @param quantite la quantite de l'ingredient a ajouter dans la recette
     */
    public void ajoutIngredientRecetteString(String ingredient,int quantite ){
        ajoutIngredientRecette(IngredientInventaire.getInstance().getIngredient(ingredient), quantite);
    }

    /**
     *
     * @return un Hashmap de la recette
     */
    public HashMap getRecette() {
        return recetteTable;
    }

    /**
     *
     * @return les kcal du plat sante
     */
    public double getKcal() { return kcal; }

    /**
     *
     * @return le Chol du plat sante
     */
    public double getChol() {
        return chol;
    }

    /**
     *
     * @return le grass du plat sante
     */
    public double getGras() {
        return gras;
    }
}
