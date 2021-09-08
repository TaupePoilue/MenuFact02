package menufact.plats;

public class  PlatFactory{

    public PlatAuMenu creerPlatRegulier(int code, String description, double prix) {
        return new PlatRegulier(code,description,prix);
    }
    public PlatAuMenu creerPlatEnfant(int code, String description, double prix, double portion) {
        return new PlatEnfant(code,description,prix,portion);
    }
    public PlatAuMenu creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        return new PlatSante(code,description,prix,kcal,chol,gras);
    }

}
