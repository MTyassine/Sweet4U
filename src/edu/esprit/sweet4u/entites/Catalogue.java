
package edu.esprit.sweet4u.entites;

import java.util.Objects;

public class Catalogue {
    
    int id;
    String nom;
    Article [] listeArticle;
    Commentaire [] listCommentaire;
    static int nbCatalogue;

    public Catalogue(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Article[] getListeArticle() {
        return listeArticle;
    }

    public static int getNbCatalogue() {
        return nbCatalogue;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setListeArticle(Article[] listeArticle) {
        this.listeArticle = listeArticle;
    }

    public static void setNbCatalogue(int nbCatalogue) {
        Catalogue.nbCatalogue = nbCatalogue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commentaire[] getListCommentaire() {
        return listCommentaire;
    }

    public void setListCommentaire(Commentaire[] listCommentaire) {
        this.listCommentaire = listCommentaire;
    }

    @Override
    public String toString() {
        return "Catalogue{" + "id=" + id + ", nom=" + nom + ", listeArticle=" + listeArticle + ", listCommentaire=" + listCommentaire + '}';
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
