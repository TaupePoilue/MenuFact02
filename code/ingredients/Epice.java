package ingredients;

public class Epice extends Ingredient{

    /**
     *
     * @param nom le nom de l'epice
     * @param description une caractéristique de l'epice
     * @param etat l'etat de l'epice
     */
    public Epice(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.EPICE);
        setEtat(etat);
    }

    /**
     *
     * @return le contenu de l'epice en chaîne de caracteres
     */
    public String toString() {
        String unite;
        if (this.getEtat().toString() == "Liquide"){unite = "Unite: millilitre";}
        else {unite = "Unite: gramme";}
        return "Ingredient: " + this.getNom()
                + ". || Descripion: " + this.getDescription()
                + ". || Type: " + this.getTypeIngredient()
                + ". || Etat: " + this.getEtat()
                + ". || " + unite;
    }
}