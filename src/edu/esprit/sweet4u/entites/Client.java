/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.entites;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nassoura
 */
public class Client extends Personne{
    private static int nbClient;
    private Commande [] listeCommande ;
 
   

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

    public Client(String nom, String prenom, String adresse, Date dateNaissance, int cin, String login, String pwd) {
        super(nom, prenom, adresse, dateNaissance, cin, login, pwd);
    }

    public Client() {
    }
    
    
}

   
   

  
    

   
    
    
    
