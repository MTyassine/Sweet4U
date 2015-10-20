/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.entites;

/**
 *
 * @author Nassoura
 */
public class Client extends Personne{
    static int nbClient;
    Commande [] listeCommande ;

    public static int getNbClient() {
        return nbClient;
    }

    public Commande[] getListeCommande() {
        return listeCommande;
    }

    public void setListeCommande(Commande[] listeCommande) {
        this.listeCommande = listeCommande;
        
    }

    @Override
    public String toString() {
        return "Client{" + "listeCommande=" + listeCommande + '}';
    }
    

   
    
    
    
}
