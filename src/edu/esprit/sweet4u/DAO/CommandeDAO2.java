/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Article;
import edu.esprit.sweet4u.entites.ArticlePanier;
import edu.esprit.sweet4u.entites.Commande;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.util.MyConnection;
import edu.esprit.sweet4u.util.PersonneConenction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WiKi
 */
public class CommandeDAO2 {
     String sql;
    Connection conn;
    Statement state;
    Personne pc;
    
    static String chaine;

    public CommandeDAO2() {
        pc=PersonneConenction.getInstance();
        conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public void ApprobationOUI(int id){
   try { //sql ="UPDATE patisserie SET code_postal ="+p.getCodePostal()+" , delegation = '"+p.getDelegation()+"' , adresse = '"+p.getAdresse()+"' WHERE id="+p.getId();
            sql = "update commande set approbation="+1+" where id="+id;
            System.out.println(sql);
            state.executeUpdate(sql);

            System.out.println("approbation mis à jour avec succÃ©e");

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erreur de mis à jour d'approbation !!!");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        } 
}
public void PaiementOUI(int id){
  try { //sql ="UPDATE patisserie SET code_postal ="+p.getCodePostal()+" , delegation = '"+p.getDelegation()+"' , adresse = '"+p.getAdresse()+"' WHERE id="+p.getId();
            sql = "update commande set paiement="+1+" where id="+id;
            System.out.println(sql);
            state.executeUpdate(sql);

            System.out.println("paiement mis à jour avec succÃ©e");

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erreur de mis à jour de paiement !!!");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        }   
}
    public void ajouterChaineACommande(String chaine_Id) {

//       int id;
//    boolean statutPayement;
//    boolean statutValidation;
//    //Article [] listeArticle;
//    List<ArticlePanier> listeArticlePanier  = new ArrayList<>();
//  
//    String modePayement;
//    String modeLivraisant;
//    float pritTotal =0f;
//    static int nbCommande;
//    static float chiffreAffaire;
        try {
            sql = "INSERT INTO commande (ArticlesPaniers)VALUES('" + chaine_Id + "')";
            System.out.println(sql);
            state.executeUpdate(sql);

            System.out.println("commande ajouter avec succÃ©e");

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("commande NON Ajoutée !!!");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        }

    }

    public List<Commande> afficherCommandesClient() {

        List<Commande> maListe = new ArrayList<Commande>();
        sql = "SELECT * FROM commande where id_c="+pc.getId();

        try {
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                Commande c = new Commande();
                c.setId(result.getInt(1));
                c.setId_rp(result.getInt(3));
                c.setStatutValidation(result.getBoolean(6));
                c.setStatutPayement(result.getBoolean(5));
                /* p.setNom(result.getString(2));
                 p.setPrenom(result.getString(3));
                 p.setCin(result.getInt(4));*/
                maListe.add(c);
            }
            return maListe;
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        }
        return maListe;

    }
     public List<Commande> afficherCommandesResponsable() {

        List<Commande> maListe = new ArrayList<Commande>();
        sql = "SELECT * FROM commande where id_rp="+pc.getId();

        try {
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                Commande c = new Commande();
                c.setId(result.getInt(1));
                c.setId_c(result.getInt(2));
                c.setStatutValidation(result.getBoolean(6));
                c.setStatutPayement(result.getBoolean(5));
                /* p.setNom(result.getString(2));
                 p.setPrenom(result.getString(3));
                 p.setCin(result.getInt(4));*/
                maListe.add(c);
            }
            return maListe;
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        }
        return maListe;

    }

    public ArticlePanier chercherUneCommandeParId(int id) {
        ArticlePanier art = new ArticlePanier();
        Article a = new Article();
        sql = "SELECT * FROM unecommande WHERE id=" + id;
        System.out.println(sql);

        try {

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
               // System.out.println(rs.getInt(1));
                //System.out.println(art.getArt());
                      a.setId(rs.getInt(1));
                      
                 a.setNom(rs.getString(6));
//                System.out.println("nom lu="+ art.getArt().getNom());
                 a.setPrix(rs.getFloat(7));
                //System.out.println("prix lu="+ art.getArt().getPrix());
                a.setPrixPromo(rs.getFloat(8));
                art.setArt(a);
                art.setQuantite(rs.getFloat(9));
            }
            System.out.println("nouvel articlePanier="+art);
            return art;
             

        } catch (SQLException ex) {

            System.err.println("Erreur recherche article ds la base");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    public String afficherDetailsCommandes(int id) {
        sql = "SELECT * FROM commande where id=" + id;
        System.out.println(sql);
        chaine =null;
        try {
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                // Commande c = new Commande();
                chaine = result.getString(4);
                System.out.println(chaine);
                /*   p.setId(result.getInt(1));
                 p.setNom(result.getString(2));
                 p.setPrenom(result.getString(3));
                 p.setCin(result.getInt(4));
                 maListe.add(p);*/
                    return chaine;
            }
           
        }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la chaine");
            Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,ex);
        }
        return chaine;
       

        }
}
