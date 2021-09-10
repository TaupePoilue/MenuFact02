package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatRegulier;

import java.util.ArrayList;

public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    private static Menu menu = null;

    private Menu(String description) {
        this.description = description;
    }

    public boolean ajoute (PlatAuMenu p)
    {
        try{
            plat.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void position(int i)
    {
        courant = i;
    }

    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    public static Menu getInstance(String description){
        if (menu == null){
            menu = new Menu(description);
        }
        return menu;
    }

    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
