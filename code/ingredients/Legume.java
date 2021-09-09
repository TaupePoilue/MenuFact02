package ingredients;

public class Legume extends Ingredient{

    /**
     *
     * @param nom le nom du Legume
     * @param description une caractéristique du Legume
     * @param etat l'etat du Legume
     */
    public Legume(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LEGUME);
        setEtat(etat);
    }

    /**
     *
     * @return le contenu du Legume en chaîne de caracteres
     */
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
