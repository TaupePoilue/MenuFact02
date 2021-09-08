package menufact.plats.EtatPlat;

import menufact.plats.PlatChoisi;

public class PlatImpossibleAPreparer extends EtatPlat{

    public PlatImpossibleAPreparer(PlatChoisi p) {
        super(p);
    }

    @Override
    public String toString() {
        return "PlatImpossibleAPreparer";
    }
}
