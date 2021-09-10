package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

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

    /**
     *
     * @param code code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param proportion nombre inferieur a 1.0 representant la portion du plat enfant
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.proportion = proportion;
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
     * @return la portion du plat
     */
    public double getProportion() {
        return proportion;
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
     * @return les caractéristique du plat enfant en chaine de caractere
     */
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
