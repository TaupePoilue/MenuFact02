package ingredients;

public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    protected Etat etat;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {this.typeIngredient = typeIngredient;}

    public void setEtat(Etat etat) {this.etat = etat;}

    public String getEtat() {return this.etat.toString();}

}
