package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.HashMap;

public interface PlatAuMenu {

    void CreerPlat();
    int getCode();
    void setCode(int code);
    String getDescription();
    void setDescription(String description);
    double getPrix();
    void setPrix(double prix);
    void ajoutIngredientRecette(Ingredient ingredient,int quantite);
    String printRecette();
    HashMap getRecette();
}

