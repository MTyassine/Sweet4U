/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.entites;

import static edu.esprit.sweet4u.entites.Commande.nbCommande;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Objects;

public class ArticlePanier {

    private int id_ArticlePanier;

    private Article art;
    private float quantite;
    //private int id_cmde;

    public ArticlePanier() {

    }

//    public int getId_cmde() {
//        return id_cmde;
//    }

    public ArticlePanier(Article art) {
        this.art = art;
        this.quantite = 1;
        
    }

    public int getId_ArticlePanier() {
        return id_ArticlePanier;
    }

   

    public Article getArt() {
        return art;
    }

    public float getQuantite() {
        return quantite;
    }

//    public void setId_cmde(int id_cmde) {
//        this.id_cmde = id_cmde;
//    }

    public void setId_ArticlePanier(int id_ArticlePanier) {
        this.id_ArticlePanier = id_ArticlePanier;
    }

    
    public void setArt(Article art) {
        this.art = art;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id_ArticlePanier;
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
        final ArticlePanier other = (ArticlePanier) obj;
        if (this.id_ArticlePanier != other.id_ArticlePanier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticlePanier{" + "id_ArticlePanier=" + id_ArticlePanier + ", art=" + art + ", quantite=" + quantite + '}';
    }

   

   

    

   

    

}
