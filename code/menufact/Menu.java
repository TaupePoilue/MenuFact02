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

    /**@param p Un PlatAuMenu qui sera ajouter au menu
     * @return Un booleen qui indique la reussite de l'operation*/
    public boolean ajoute (PlatAuMenu p)
    {
        try{
            plat.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    /** @param  i Indexe du plat qui sera selectionner*/
    public void position(int i)
    {
        courant = i;
    }

    /** @return Le plat qui est selectionner*/
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /** Change la position du plat courant pour le plat suivant*/
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /** Change la position du plat courant pour le plat precedant*/
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /** @param description Description du menu
     * @return Retourne l'instance du menu*/
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
