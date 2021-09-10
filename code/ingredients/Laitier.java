package ingredients;

public class Laitier extends Ingredient{

    /**
     *
     * @param nom le nom de l'objet Laitier
     * @param description une caractéristique de l'objet Laitier
     * @param etat l'etat de l'objet Laitier
     */
    public Laitier(String nom, String description, Etat etat)
    {
        setNom(nom);
        setDescription(description);
        setTypeIngredient(TypeIngredient.LAITIER);
        setEtat(etat);
    }

    /**
     *
     * @return le contenu de l'objet Laitier en chaîne de caracteres
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
        };


    }

