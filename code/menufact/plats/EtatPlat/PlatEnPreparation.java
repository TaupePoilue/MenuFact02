package menufact.plats.EtatPlat;

import menufact.plats.PlatChoisi;

public class PlatEnPreparation extends EtatPlat{

    public PlatEnPreparation(PlatChoisi p) {
        super(p);
        //Retirer les ingredients de l'inventaire (A Faire)
        p.terminer();
    }

    @Override
    public void terminer(){
        platChoisi.changerEtat(new PlatTermine(platChoisi));
    }

    @Override
    public String toString() {
        return "PlatEnPreparation";
    }
}
