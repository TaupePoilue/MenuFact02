package menufact.plats;

import ingredients.IngredientInventaire;
import menufact.plats.EtatPlat.*;
import menufact.plats.exceptions.PlatException;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;

        if(IngredientInventaire.getInstance().verifierInventaire(plat.getRecette())){
            this.etat = new PlatCommande(this);
        }else
        {
            this.etat = new PlatImpossibleAPreparer(this);
        }
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public void servir() throws PlatException{
        etat.servir();
    }

    public void preparer() throws PlatException{
        etat.preparer();
    }

    public void terminer() throws PlatException{
        etat.terminer();
    }

    public void changerEtat(EtatPlat nouvelEtat){
        etat = nouvelEtat;
    }

    public EtatPlat getEtat(){
        return this.etat;
    }
}
