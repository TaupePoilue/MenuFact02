package ingredients;

public class Viande extends Ingredient{

    /**
     *
     * @param nom le nom de la Viande
     * @param description une caractéristique de la Viande
     * @param etat l'etat de la Viande
     */
    public Viande(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.VIANDE);
        setEtat(etat);
    }

    /**
     *
     * @return le contenu de la Viande en chaîne de caracteres
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
