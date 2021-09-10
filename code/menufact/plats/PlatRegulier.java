package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PlatRegulier implements PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    public HashMap<Ingredient, Integer> recetteTable = new HashMap<Ingredient, Integer>();

    /**
     *
     * @param code code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     */
    public PlatRegulier(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }
    public void CreerPlat(){}

    public PlatRegulier() {}

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
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

    /**
     *
     * @param ingredient un ingredient pour la recette
     * @param quantite la quantite de l'ingredient pour la recette
     */
    public void ajoutIngredientRecette(Ingredient ingredient,int quantite){
            this.recetteTable.put(ingredient, quantite);
    }

    /**
     *
     * @param ingredient un ingredient sous forme de chaine de caractere pour la recette
     * @param quantite la quantite de l'ingredient pour la recette
     */
    public void ajoutIngredientRecetteString(String ingredient,int quantite ){
        ajoutIngredientRecette(IngredientInventaire.getInstance().getIngredient(ingredient), quantite);
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
     * @return un Hashmap de la recette
     */
    public HashMap getRecette() {
        return recetteTable;
    }
}
