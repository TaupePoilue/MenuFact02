package ingredients;


public class Fruit extends Ingredient{

    /**
     *
     * @param nom le nom du Fruit
     * @param description une caractéristique du Fruit
     * @param etat l'etat du Fruit
     */
    public Fruit(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.FRUIT);
        setEtat(etat);
    }

    /**
     *
     * @return le contenu du Fruit en chaîne de caracteres
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
