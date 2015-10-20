
package edu.esprit.sweet4u.entites;

class Article {
    
    String nom;
    float prix;
    float prixPromo;
    float quantite;
    static int nbVente;
    static int nbSatisfaction;

    public Article(String nom, float prix, float prixPromo, float quantite) {
        this.nom = nom;
        this.prix = prix;
        this.prixPromo = prixPromo;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public float getPrixPromo() {
        return prixPromo;
    }

    public float getQuantite() {
        return quantite;
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

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public static void setNbVente(int nbVente) {
        Article.nbVente = nbVente;
    }

    public static void setNbSatisfaction(int nbSatisfaction) {
        Article.nbSatisfaction = nbSatisfaction;
    }

    @Override
    public String toString() {
        return "Article{" + "nom=" + nom + ", prix=" + prix + ", prixPromo=" + prixPromo + ", quantite=" + quantite + '}';
    }
    
    
    
}
