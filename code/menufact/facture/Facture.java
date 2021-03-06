package menufact.facture;

import menufact.Chef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;

    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**Definition des possibles etats de Facture*/

    public class FactureEtat {

        /**Ouvre la facture - Impossible si la facture est PAYEE*/
        public void ouvrir() throws FactureException {}

        /**FERME la facture - Impossible si la facture est PAYEE*/
        public void fermer() throws  FactureException{}

        /**PAYE la facture*/
        public void payer() throws FactureException{}

        /**@param index Index du plat qui sera selectionner, donc le prochain plat courrant*/
        public void selectionnerPlat(int index) throws  FactureException {}

        /** Retire le plat courrant*/
        public void retirerPlat() throws FactureException{}

        /** Ajoute un plat a la Facture seulement si elle est OUVERTE
         * @param plat - un plat choisi*/
        public void ajouterPlat(PlatChoisi plat) throws FactureException {
            throw new FactureException("Un plat peut seulement être ajouter à une facture OUVERTE."); }

        public String genererFacture(){
            String lesPlats = new String();
            String factureGenere = new String();

            int i =1;


            factureGenere =   "Facture generee.\n" +
                    "Date:" + date + "\n" +
                    "Description: " + description + "\n" +
                    "Client:" + client.getNom() + "\n" +
                    "Les plats commandes:" + "\n" + lesPlats;

            factureGenere += "Seq   Plat         Prix   Quantite\n";
            for (PlatChoisi plat : platchoisi)
            {
                factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
                i++;
            }

            factureGenere += "          TPS:               " + tps() + "\n";
            factureGenere += "          TVQ:               " + tvq() + "\n";
            factureGenere += "          Le total est de:   " + total() + "\n";

            return factureGenere;
        }
    }

    public class FactureFermer extends FactureEtat {
        @Override
        public void ouvrir() throws FactureException {
            changerEtat(new FactureOuverte());
        }

        @Override
        public void fermer() throws FactureException {}

        @Override
        public void payer() throws FactureException {
            changerEtat(new FacturePayee());
        }

        @Override
        public void ajouterPlat(PlatChoisi plat) throws FactureException {
            throw new FactureException("Impossible d'ajouter un plat a une facture FERMEE; Veuillez la reouvrir");
        }

        @Override
        public void selectionnerPlat(int index) throws FactureException {
            throw new FactureException("Impossible de selectionner un plat a une facture FERMEE; Veuillez la reouvrir");
        }

        @Override
        public void retirerPlat() throws FactureException {
            throw new FactureException("Impossible de retirer un plat a une facture FERMEE; Veuillez la reouvrir");
        }

        @Override
        public String genererFacture() {
            return super.genererFacture() + "\n" + "Etat de la facture: FERMEE";
        }
    }

    public class FactureOuverte extends FactureEtat {

        @Override
        public void ouvrir() {}

        @Override
        public void fermer() {
            changerEtat(new FactureFermer());
        }

        @Override
        public void payer() {
            changerEtat(new FacturePayee());
        }

        @Override
        public void ajouterPlat(PlatChoisi plat) {
            platchoisi.add(plat);
        }

        @Override
        public void selectionnerPlat(int index) throws FactureException{
            //TO DO
            throw new FactureException("SelectionnerPlat pas encore implemente");
        }

        @Override
        public void retirerPlat() throws FactureException {
            if (courant == -1)
            {
                throw new FactureException("Impossible de retirer: Aucun plat de selectionne");
            }
            platchoisi.remove(courant);
        }

        @Override
        public String genererFacture() {
            String lesPlats = new String();
            String factureGenere = new String();

            int i =1;

            factureGenere =   "Facture generee.\n" +
                    "Date:" + date + "\n" +
                    "Description: " + description + "\n" +
                    "Client:" + client.getNom() + "\n" +
                    "Les plats commandes:" + "\n" + lesPlats + "\n" +
                    "Etat de la facture : OUVERTE";

            return factureGenere;
        }
    }

    public class FacturePayee extends FactureEtat {

        @Override
        public void payer() throws FactureException {
            throw new FactureException("Impossible de paye une facture deja payee");
        }

        @Override
        public void ouvrir() throws FactureException {
            throw new FactureException("Impossible d'ouvrir une facture payee");
        }

        @Override
        public void fermer() throws FactureException {
            throw new FactureException("Impossible de fermer une facture payee");
        }

        @Override
        public void ajouterPlat(PlatChoisi plat) throws FactureException {
            throw new FactureException("Impossible d'ajouter un plat a une facture PAYEE");
        }

        @Override
        public void selectionnerPlat(int index) throws FactureException {
            throw new FactureException("Impossible de selectionner un plat a une facture PAYEE");
        }

        @Override
        public void retirerPlat() throws FactureException {
            throw new FactureException("Impossible de retirer un plat a une facture PAYEE");
        }

        @Override
        public String genererFacture() {
            return super.genererFacture() + "\n" + "Etat de la facture: PAYEE";
        }
    }

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()  throws FactureException
    {
       etat.payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException
    {
       etat.fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        etat.ouvrir();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new FactureOuverte();
        courant = -1;
        this.description = description;
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        try{
            notifierChef(p);
            etat.ajouterPlat(p);
        }catch (PlatException pe){
            throw new FactureException(pe.getMessage());
        }
    }

    /**@param index Index du plat qui sera selectionne*/
    public void selectionnerPlat(int index) throws FactureException
    {
        etat.selectionnerPlat(index);
    }

    /** Retire le plat courrant*/
    public void retirerPlat() throws FactureException
    {
        etat.retirerPlat();
    }

    /**Notifie le chef lorsqu'un plat est ajoute a la facture
     * @param p Un plat qui a ete ajoute a la facture*/
    public void notifierChef(PlatChoisi p) throws PlatException{
        Chef.getInstance().recevoirCommande(p);
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        return etat.genererFacture();
    }

    public void changerEtat(FactureEtat nouvelEtat){
        this.etat = nouvelEtat;
    }
}
