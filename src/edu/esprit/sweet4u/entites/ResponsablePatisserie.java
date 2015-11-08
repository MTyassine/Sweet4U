/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.entites;

import java.sql.Date;

/**
 *
 * @author Nassoura
 */
public class ResponsablePatisserie extends Personne {
    private String nom_patisserie;
    private String adresse_Patisserie;
    static int nbResponsable;
    static int nbPatisserie;
    Catalogue [] listCatalogue;

    public ResponsablePatisserie(String nom_patisserie, String adresse_Patisserie, String nom, String prenom, String adresse,Date dateNaissance, int cin, String login, String pwd) {
        super(nom, prenom, adresse, dateNaissance, cin, login, pwd);
        this.nom_patisserie = nom_patisserie;
        this.adresse_Patisserie = adresse_Patisserie;
    }

   
    

    public String getNom_patisserie() {
        return nom_patisserie;
    }

    public String getAdresse_Patisserie() {
        return adresse_Patisserie;
    }

    public void setNom_patisserie(String nom_patisserie) {
        this.nom_patisserie = nom_patisserie;
    }

    public void setAdresse_Patisserie(String adresse_Patisserie) {
        this.adresse_Patisserie = adresse_Patisserie;
    }

  

   

    public static int getNbResponsable() {
        return nbResponsable;
    }

    public static void setNbResponsable(int nbResponsable) {
        ResponsablePatisserie.nbResponsable = nbResponsable;
    }

    public static int getNbPatisserie() {
        return nbPatisserie;
    }

    public static void setNbPatisserie(int nbPatisserie) {
        ResponsablePatisserie.nbPatisserie = nbPatisserie;
    }

    public ResponsablePatisserie() {
    }
    
}
