package menufact.plats;

import menufact.plats.PlatAuMenu;

public class PlatSante implements Plat {
    private int code;
    private String description;
    private double prix;
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {

        this.code = code;
        this.description = description;
        this.prix = prix;
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }
    public void CreerPlat(){}

    public PlatSante() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} {" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getKcal() { return kcal; }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}
