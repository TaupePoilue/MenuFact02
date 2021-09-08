package menufact.plats;

public class  PlatFactory{

    public Plat creerPlat(int code, String description, double prix) {
        return new PlatAuMenu(code,description,prix);
    }
    public Plat creerPlatEnfant(int code, String description, double prix, double portion) {
        return new PlatEnfant(code,description,prix,portion);
    }
    public Plat creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        return new PlatSante(code,description,prix,kcal,chol,gras);
    }

}
