
package edu.esprit.sweet4u.entites;

public class Commande {
    
    boolean statutPayement;
    boolean statutValidation;
    Article [] listeArticle;
    String modePayement;
    String modeLivraisant;
    float pritTotal =0f;
    static int nbCommande;
    static float chiffreAffaire;

    public Commande(boolean statutPayement, boolean statutValidation, String modePayement, String modeLivraisant) {
        this.statutPayement = statutPayement;
        this.statutValidation = statutValidation;
        this.modePayement = modePayement;
        this.modeLivraisant = modeLivraisant;
    }

    public boolean isStatutPayement() {
        return statutPayement;
    }

    public boolean isStatutValidation() {
        return statutValidation;
    }

    public Article[] getListeArticle() {
        return listeArticle;
    }

    public String getModePayement() {
        return modePayement;
    }

    public String getModeLivraisant() {
        return modeLivraisant;
    }

    public float getPritTotal() {
        return pritTotal;
    }

    public static int getNbCommande() {
        return nbCommande;
    }

    public static float getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setStatutPayement(boolean statutPayement) {
        this.statutPayement = statutPayement;
    }

    public void setStatutValidation(boolean statutValidation) {
        this.statutValidation = statutValidation;
    }

    public void setListeArticle(Article[] listeArticle) {
        this.listeArticle = listeArticle;
    }

    public void setModePayement(String modePayement) {
        this.modePayement = modePayement;
    }

    public void setModeLivraisant(String modeLivraisant) {
        this.modeLivraisant = modeLivraisant;
    }

    public void setPritTotal(float pritTotal) {
        this.pritTotal = pritTotal;
    }

    public static void setNbCommande(int nbCommande) {
        Commande.nbCommande = nbCommande;
    }

    public static void setChiffreAffaire(float chiffreAffaire) {
        Commande.chiffreAffaire = chiffreAffaire;
    }
    
    
    
}
