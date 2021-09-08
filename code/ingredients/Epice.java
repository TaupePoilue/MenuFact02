package ingredients;

public class Epice extends Ingredient{
    public Epice(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.EPICE);
        setEtat(etat);
    }

    public String toString() {
        String unite;
        if (this.getEtat() == "Liquide"){unite = "Unite: millilitre";}
        else {unite = "Unite: gramme";}
        return "Ingredient: " + this.getNom()
                + ". || Descripion: " + this.getDescription()
                + ". || Type: " + this.getTypeIngredient()
                + ". || Etat: " + this.getEtat()
                + ". || " + unite;
    }
}