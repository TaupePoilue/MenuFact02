package menufact.plats;


public class TestPlat {
    public static void main(String[] args){

        System.out.println("===TEST PLATCHOISI===");

        TestPlat tp = new TestPlat();

        PlatAuMenu p1 = new PlatAuMenu();
        PlatChoisi platChoisi = new PlatChoisi(p1, 2);

        try {
            tp.test1_PreparerPlatChoisi(platChoisi);
            System.out.println("Test1 - REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
            tp.test2_TerminerPlatChoisi(platChoisi);
            System.out.println("Test2 - REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try {
            tp.test3_ServirPlatChoisi(platChoisi);
            System.out.println("Test3 - REUSSI");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void test1_PreparerPlatChoisi(PlatChoisi p) throws Exception{
        System.out.println("===Test1");
        p.preparer();
        if(!p.toString().equals("PlatEnPreparation")){
            throw new Exception("Test1 - ECHEC");
        }
    }

    public void test2_TerminerPlatChoisi(PlatChoisi p) throws Exception{
        p.terminer();
        if(!p.toString().equals("PlatTermine")){
            throw new Exception("Test2 - ECHEC");
        }
    }

    public void test3_ServirPlatChoisi(PlatChoisi p) throws Exception{
        p.servir();
        if(!p.toString().equals("PlatServi")){
            throw new Exception("Test3 - ECHEC");
        }
    }
}
