package menufact.plats;

public class PlatEnfant implements PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private double proportion;

    public PlatEnfant() {
    }
    public void CreerPlat(){}

    public PlatEnfant(int code, String description, double prix, double proportion) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.proportion = proportion;
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

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} {"  +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }
}
