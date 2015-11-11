/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import static edu.esprit.sweet4u.DAO.CatalogueD.idCatalogue;
import edu.esprit.sweet4u.entites.Article;

import edu.esprit.sweet4u.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nassoura
 */
public class ArticleDAO {
     int idCatalogue = CatalogueD.idCatalogue;
     static int idArticle;
     Connection cnx;
     Article ar = new Article();
    public ArticleDAO() {
        cnx = MyConnection.getInstance();
    }
    public void ajouterArticle(Article a) {
        String url = " INSERT INTO article (nom,prix,prix_promo,id_catalogue) VALUES (?,?,?,?)";
        try {
            PreparedStatement prst = cnx.prepareStatement(url);
            prst.setString(1, a.getNom());
            prst.setFloat(2, a.getPrix());
            prst.setFloat(3, a.getPrixPromo());
            prst.setInt(4, a.getIdCatalogue());
            prst.executeUpdate();
            System.out.println(prst);
            System.out.println("Article Ajouté!!!!");
        } catch (SQLException ex) {
            System.err.println("Probleme d'insertion");
        }
    }
    public List<Article> afficherArticle() {
        List<Article> listeC = new ArrayList<Article>();
        String url = "SELECT * FROM article where id_catalogue=" + idCatalogue;
        try {
            Statement st = MyConnection.getInstance().createStatement();
            ResultSet rst = st.executeQuery(url);
            while (rst.next()) {
                Article a = new Article();
                a.setNom(rst.getString(2));
                a.setPrix(rst.getFloat(3));
                a.setPrixPromo(rst.getFloat(4));
                System.out.println(url);
                System.out.println(a);
                listeC.add(a);
            }
            System.out.println(listeC);
            return listeC;
        } catch (SQLException ex) {
            return null;
        }
    
    }
        public boolean modifierArticle(Article ar, String a) {
        String url = " UPDATE article SET nom=? , prix=?,prix_promo=? WHERE id_catalogue='" + idCatalogue +"'&& id='"+idArticle+ "'&& nom='"+a+"'";
        System.out.println(url);
        try {
            PreparedStatement prst =cnx.prepareStatement(url);
            prst.setString(1, ar.getNom());
            prst.setFloat(2, ar.getPrix());
            prst.setFloat(3, ar.getPrixPromo());
            prst.executeUpdate();
            System.out.println(url);
            return true;
        } catch (SQLException ex) {
            System.err.println("Echec de modification!");
            return false;

        }
    }
      public boolean supprimerArticle(String a) {
       String url = "DELETE FROM article WHERE id_catalogue="+idCatalogue+" AND nom='"+a+"'";
       System.out.println(url);
        try {
            PreparedStatement prst =cnx.prepareStatement(url);
            prst.executeUpdate();
            System.out.println(url);
            return true;
        } catch (SQLException ex) {
            System.err.println("Echec de supprission!");
            return false;

        }
    }
     
         public int trouverIdArticleParNom(String nom) {

        String requete = "SELECT id FROM article WHERE nom=?";
        int id_A=0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            statement.setString(1, nom);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id_A=rs.getInt(1);
                idArticle=id_A;
                return id_A;
            }

        } catch (SQLException ex) {
            //System.err.println("erreur de recherche");
            ex.printStackTrace();
        }
        return id_A;
    }






}
