package menufact.plats.EtatPlat;

import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;

public class EtatPlat {

    protected PlatChoisi platChoisi;

    public EtatPlat(PlatChoisi p){
        platChoisi = p;
    }

    public void preparer() throws  PlatException{ throw new PlatException("Plat impossible a preparer");}

    public void terminer() throws PlatException { throw new PlatException("Plat impossible a terminer");}

    public void servir() throws  PlatException{ throw new PlatException("Plat impossible a servir");}
}
