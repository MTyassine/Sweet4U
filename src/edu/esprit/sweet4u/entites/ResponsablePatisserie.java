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
public class ResponsablePatisserie extends Personne {
    private String patisserie;
    private String adressePatisserie;
    static int nbResponsable;
    static int nbPatisserie;
    Catalogue [] listCatalogue;

    public String getPatisserie() {
        return patisserie;
    }

    public void setPatisserie(String patisserie) {
        this.patisserie = patisserie;
    }

    public String getAdressePatisserie() {
        return adressePatisserie;
    }

    public void setAdressePatisserie(String adressePatisserie) {
        this.adressePatisserie = adressePatisserie;
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
    
}
