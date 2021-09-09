package menufact.plats;

public class  PlatFactory{

    /**
     *
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     */
    public PlatAuMenu creerPlatRegulier(int code, String description, double prix) {
        return new PlatRegulier(code,description,prix);
    }

    /**
     *
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param portion la grosseur de la portion du plat
     */
    public PlatAuMenu creerPlatEnfant(int code, String description, double prix, double portion) {
        return new PlatEnfant(code,description,prix,portion);
    }

    /**
     *
     * @param code le code du plat
     * @param description la description du plat
     * @param prix le prix du plat
     * @param kcal la quantite de calories du plat
     * @param chol la quantite de cholesterol du plat
     * @param kcal la quantite de gras
     */
    public PlatAuMenu creerPlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        return new PlatSante(code,description,prix,kcal,chol,gras);
    }

}
