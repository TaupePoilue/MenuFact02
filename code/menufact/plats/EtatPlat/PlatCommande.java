package menufact.plats.EtatPlat;

import ingredients.IngredientInventaire;
import menufact.plats.PlatChoisi;

public class PlatCommande extends EtatPlat{

    public PlatCommande(PlatChoisi platChoisi) {
        super(platChoisi);
    }

    @Override
    public void preparer(){
        IngredientInventaire.getInstance().soustraireQuantite(platChoisi.getPlat().getRecette());
        platChoisi.changerEtat(new PlatEnPreparation(platChoisi));
    }

    @Override
    public String toString() {
        return "PlatCommande";
    }
}
