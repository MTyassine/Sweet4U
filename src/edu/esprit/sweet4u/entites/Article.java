/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.entites;

import java.util.Objects;

/**
 *
 * @author Nassoura
 */
public class Article {
    
     private int id;
    private String nom;
    private float prix;
    private float prixPromo;
    private int idCatalogue;

 
    static int nbVente;
    static int nbSatisfaction;
    public Article(int id ,String nom, float prix, float prixPromo) {
        this.id= id;
        this.nom = nom;
        this.prix = prix;
        this.prixPromo = prixPromo;
        
    }
    public Article(String nom, float prix, float prixPromo) {
        
        this.nom = nom;
        this.prix = prix;
        this.prixPromo = prixPromo;
        
    }
    

    public Article() {}
   
   
   
   
    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public float getPrixPromo() {
        return prixPromo;
    }

    

    public static int getNbVente() {
        return nbVente;
    }

    public static int getNbSatisfaction() {
        return nbSatisfaction;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setPrixPromo(float prixPromo) {
        this.prixPromo = prixPromo;
    }

      public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }
    

    public static void setNbVente(int nbVente) {
        Article.nbVente = nbVente;
    }

    public static void setNbSatisfaction(int nbSatisfaction) {
        Article.nbSatisfaction = nbSatisfaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixPromo=" + prixPromo + '}';
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
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
