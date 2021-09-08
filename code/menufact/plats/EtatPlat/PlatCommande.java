package menufact.plats.EtatPlat;

import menufact.plats.PlatChoisi;

public class PlatCommande extends EtatPlat{

    public PlatCommande(PlatChoisi platChoisi) {
        super(platChoisi);
    }

    @Override
    public void preparer(){
        platChoisi.changerEtat(new PlatEnPreparation(platChoisi));
    }

    @Override
    public String toString() {
        return "PlatCommande";
    }
}
