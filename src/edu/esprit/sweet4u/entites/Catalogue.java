
package edu.esprit.sweet4u.entites;

import java.util.Objects;

public class Catalogue {
    
    int id;
    String nom;
    private int id_rp;
     private  String lien;
   // Article [] listeArticle;
    //Commentaire [] listCommentaire;
    static int nbCatalogue;

    public Catalogue(String nom ,int id,int id_rp) {
        this.nom = nom;
        this.id=id;
        this.id_rp=id_rp;
    }
     public Catalogue() {
        
    }

    public String getNom() {
        return nom;
    }

   // public Article[] getListeArticle() {
       // return listeArticle;
    //}

    public static int getNbCatalogue() {
        return nbCatalogue;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   // public void setListeArticle(Article[] listeArticle) {
     //   this.listeArticle = listeArticle;
    //}

   // public static void setNbCatalogue(int nbCatalogue) {
     //   Catalogue.nbCatalogue = nbCatalogue;
    //}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rp() {
        return id_rp;
    }

    public void setId_rp(int id_rp) {
        this.id_rp = id_rp;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    // public Commentaire[] getListCommentaire() {
    //    return listCommentaire;
    // }
    //  public void setListCommentaire(Commentaire[] listCommentaire) {
    //     this.listCommentaire = listCommentaire;
    // }
    @Override
    public String toString() {
        return "Catalogue{" + "id=" + id + ", nom=" + nom + ", id_rp=" + id_rp + ", lien=" + lien + '}';
    }

   


    @Override
    public int hashCode() {
        int hash = 3;
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
        final Catalogue other = (Catalogue) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
    
    
}
