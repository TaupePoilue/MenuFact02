package menufact;

import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;

public class Chef {
    private static Chef chef = null;

    private Chef(){}

    public static Chef getInstance(){
        if (chef == null)
        {
            chef = new Chef();
        }
        return chef;
    }

    public void recevoirCommande(PlatChoisi p) throws PlatException {
        p.preparer();
        p.terminer();
    }
}
