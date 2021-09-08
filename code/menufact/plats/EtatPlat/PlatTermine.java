package menufact.plats.EtatPlat;

import menufact.plats.PlatChoisi;

public class PlatTermine extends EtatPlat{
    public PlatTermine(PlatChoisi p){
        super(p);
    }

    @Override
    public void servir() {
        platChoisi.changerEtat(new PlatServi(platChoisi));
    }

    @Override
    public String toString() {
        return "Plat termine.";
    }
}
