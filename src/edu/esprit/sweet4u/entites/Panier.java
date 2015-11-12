/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.entites;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WiKi
 */
public class Panier {
    public final static List<ArticlePanier> listeArtPan=new ArrayList<>();

    public Panier() {
     
    }
    

//    public Panier(List<ArticlePanier> listeArtPan) {
//        this.listeArtPan = listeArtPan;
//    } 
    
    public void ajouterAuPanier(ArticlePanier a){
        listeArtPan.add(a);
    }

    public List<ArticlePanier> getListeArtPan() {
        return listeArtPan;
    }

    

  
    

   /* public void setListeArtPan(List<ArticlePanier> listeArtPan) {
        this.listeArtPan = listeArtPan;
    }*/

    @Override
    public String toString() {
        return "Panier{" + "listeArtPan=" + listeArtPan + '}';
    }

   
    
    
}
