
package edu.esprit.sweet4u.entites;

import static edu.esprit.sweet4u.entites.Panier.listeArtPan;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    
    
    int id;
    int id_c;
    int id_rp;
    boolean statutPayement;
    boolean statutValidation;
    //Article [] listeArticle;
    public final static ArrayList<ArticlePanier> listeArticlePanier  = new ArrayList<ArticlePanier>();
 
    String modePayement;
    String modeLivraisant;
    float pritTotal =0f;
    static int nbCommande;
    static float chiffreAffaire;

    public Commande(){}
    public Commande(boolean statutPayement, boolean statutValidation, String modePayement, String modeLivraisant) {
        this.statutPayement = statutPayement;
        this.statutValidation = statutValidation;
        this.modePayement = modePayement;
        this.modeLivraisant = modeLivraisant;
        nbCommande++;
        
    }


/*
 public static String getListIdArticles(Panier pan) {
       String chaine_Id="";
       
      for(int i=0;i<pan.getListeArtPan().size();i++){
           chaine_Id=chaine_Id+"|"+pan.getListeArtPan().get(i).getId_ArticlePanier();
       }
       return chaine_Id;
   }*/

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public int getId_rp() {
        return id_rp;
    }

    public void setId_rp(int id_rp) {
        this.id_rp = id_rp;
    }

    public boolean isStatutPayement() {
        return statutPayement;
    }

    public boolean isStatutValidation() {
        return statutValidation;
    }

   

   public void ajouterAuPanier(ArticlePanier a){
        listeArticlePanier.add(a);
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

    public int getId() {
        return id;
    }

//    public void ajouterAuPanier(ArticlePanier a){
//        listeArtPan.add(a);
//    }
 public ArrayList<ArticlePanier> getListeArtPan() {
        return listeArticlePanier;
    }
//    public static List<ArticlePanier> getListeArticlePanier() {
//        return listeArticlePanier;
//    }
   

    
    public void setStatutPayement(boolean statutPayement) {
        this.statutPayement = statutPayement;
    }

    public void setStatutValidation(boolean statutValidation) {
        this.statutValidation = statutValidation;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", statutPayement=" + statutPayement + ", statutValidation=" + statutValidation + ", listeArticlePanier=" + listeArticlePanier + ", modePayement=" + modePayement + ", modeLivraisant=" + modeLivraisant + ", pritTotal=" + pritTotal + '}';
    }
    

}