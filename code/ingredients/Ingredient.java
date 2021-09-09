package ingredients;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    protected Etat etat;

    /**
     *
     * @return le nom le nom de l'ingredient
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom le nom de l'ingredient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return la description de l'ingredient
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description la description de l'ingredient
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return le type de l'ingredient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     *
     * @param typeIngredient le type de l'ingredient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {this.typeIngredient = typeIngredient;}

    /**
     *
     * @param etat l'etat de l'ingredient
     */
    public void setEtat(Etat etat) {this.etat = etat;}

    /**
     *
     * @return l'etat de l'ingredient
     */
    public String getEtat() {return this.etat.toString();}

}
