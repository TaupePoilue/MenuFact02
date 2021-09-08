package menufact.plats;

public class TestPlat {
    public static void main(String[] args) {

        try {
            String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
            System.out.println("===package menufact.plats debut test UNITAIRE==="+ newLine);
            System.out.println("===Creation de 3 plats===");

            PlatFactory platFactory = new PlatFactory();
            Plat plat1 = platFactory.creerPlat(1,"Frite",12.50);
            System.out.println("plat1: " + plat1.toString());
            Plat plat2 = platFactory.creerPlatEnfant(2,"Tomate",12.50,0.5);
            System.out.println("plat2: " + plat2.toString());
            Plat plat3 = platFactory.creerPlatSante(3,"Apple",12.50,50,40,10);
            System.out.println("plat3: " + plat3.toString());
            System.out.println();
            //CODE
            System.out.println("===getCode des 3 plats===");
            System.out.println("plat1 Code: " + plat1.getCode());
            System.out.println("plat2 Code: " + plat2.getCode());
            System.out.println("plat3 Code: " + plat3.getCode());
            System.out.println();
            System.out.println("===setCode des 3 plats===");
            plat1.setCode(3);
            plat2.setCode(2);
            plat3.setCode(1);
            System.out.println("plat1 Code: " + plat1.getCode());
            System.out.println("plat2 Code: " + plat2.getCode());
            System.out.println("plat3 Code: " + plat3.getCode());
            System.out.println();
            //DESCRIPTION
            System.out.println("===getDescription des 3 plats===");
            System.out.println("plat1 Description: " + plat1.getDescription());
            System.out.println("plat2 Description: " + plat2.getDescription());
            System.out.println("plat3 Description: " + plat3.getDescription());
            System.out.println();
            System.out.println("===setDescription des 3 plats===");
            plat1.setDescription("Manger");
            plat2.setDescription("Manger");
            plat3.setDescription("Manger");
            System.out.println("plat1 Description: " + plat1.getDescription());
            System.out.println("plat2 Description: " + plat2.getDescription());
            System.out.println("plat3 Description: " + plat3.getDescription());
            //PRIX
            System.out.println();
            System.out.println("===getPrix des 3 plats===");
            System.out.println("plat1 Prix: " + plat1.getPrix());
            System.out.println("plat2 Prix: " + plat2.getPrix());
            System.out.println("plat3 Prix: " + plat3.getPrix());
            System.out.println();
            System.out.println("===setPrix des 3 plats===");
            plat1.setPrix(2.55);
            plat2.setPrix(3.67);
            plat3.setPrix(6.66);
            System.out.println("plat1 Prix: " + plat1.getPrix());
            System.out.println("plat2 Prix: " + plat2.getPrix());
            System.out.println("plat3 Prix: " + plat3.getPrix());
            System.out.println();
            System.out.println("===Impression des 3 plats===");
            System.out.println("plat1: " + plat1.toString());
            System.out.println("plat2: " + plat2.toString());
            System.out.println("plat3: " + plat3.toString());







        } catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
