
package edu.esprit.sweet4u.entites;

public class Reclamation {
    
    Personne emeteur, destinataire;
    String sujet, contenu;
    static int nbReclamation;

    public Reclamation(Personne emeteur, Personne destinataire, String sujet, String contenu) {
        this.emeteur = emeteur;
        this.destinataire = destinataire;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    public Personne getEmeteur() {
        return emeteur;
    }

    public void setEmeteur(Personne emeteur) {
        this.emeteur = emeteur;
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public static int getNbReclamation() {
        return nbReclamation;
    }

    public static void setNbReclamation(int nbReclamation) {
        Reclamation.nbReclamation = nbReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "emeteur=" + emeteur + ", destinataire=" + destinataire + ", sujet=" + sujet + ", contenu=" + contenu + '}';
    }
    
    
    
    
    
}
