/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import static edu.esprit.sweet4u.DAO.ArticleDAO.idArticle;
import edu.esprit.sweet4u.entites.Catalogue;
import edu.esprit.sweet4u.entites.Article;
import edu.esprit.sweet4u.entites.Personne;

import edu.esprit.sweet4u.util.MyConnection;
import edu.esprit.sweet4u.util.PersonneConenction;
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
public class CatalogueD {
    Personne pc;
    
    static int idCatalogue;
    Connection cnx;
Catalogue c = new Catalogue();
    public CatalogueD() {
        pc=PersonneConenction.getInstance();
        cnx = MyConnection.getInstance();
    }

    
    public void ajouterCatalogue(Catalogue c) {
        String url = " INSERT INTO catalogue (nom,pic,id_rp) VALUES (?,?,"+pc.getId()+")";
        try {
            PreparedStatement prst = cnx.prepareStatement(url);
            prst.setString(1, c.getNom());
            prst.setString(2, c.getLien());
            prst.executeUpdate();
            System.out.println(prst);
            System.out.println("Insertion effectuée!");
        } catch (SQLException ex) {
            System.err.println("Probleme d'insertion");
        }
    }

     public boolean modifierCatalogue(Catalogue c,int idC) {
        String url = " UPDATE catalogue SET nom=?, pic=? WHERE id='" + idC +"'";
        System.out.println(url);
        try {
            PreparedStatement prst =cnx.prepareStatement(url);
            prst.setString(1, c.getNom());
            prst.setString(2, c.getLien());
            prst.executeUpdate();
            System.out.println(url);
            return true;
        } catch (SQLException ex) {
            System.err.println("Echec de modification!");
            return false;

        }
    }

    public void supprimerCatalogue(Catalogue c ,int idC) {
        String requete = "DELETE FROM catalogue WHERE id='" + idC +"'";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.executeUpdate();
            System.out.println("Suppression effectué");
        } catch (SQLException ex) {
            System.err.println("Erreur de la suppression");
        }
    }
     public void supprimerArticleDuCatalogue(Article a,int idC) {
        String requete = "DELETE FROM article WHERE id_catalogue='" + idC +"'";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.executeUpdate();
            System.out.println("Suppression effectué");
        } catch (SQLException ex) {
            System.err.println("Erreur de la suppression");
        }
    }


   
     

    public List<Catalogue> afficherLesCatalogues() {
        List<Catalogue> maListe = new ArrayList<>();
        String requete = "SELECT * FROM catalogue";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
            Catalogue c = new Catalogue();
            c.setId(rs.getInt(1));
            c.setNom(rs.getString(2));
            c.setLien(rs.getString(3));
            maListe.add(c);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return null;
        }
    public List<Catalogue> afficherCatalogueResponsable() {
        List<Catalogue> listeC = new ArrayList<Catalogue>();
        String url = "SELECT * FROM catalogue where id_rp=" + pc.getId();
        try {
            Statement st = MyConnection.getInstance().createStatement();
            ResultSet rst = st.executeQuery(url);
            while (rst.next()) {
                Catalogue c = new Catalogue();
                c.setNom(rst.getString(2));
                c.setLien(rst.getString(3));
                System.out.println(url);
                System.out.println(c);
                listeC.add(c);}
                System.out.println(listeC);
                return listeC;
        } catch (SQLException ex) {
            return null;
        }
    }
    
     public Catalogue trouverCatalogueParId(int id) {

      Catalogue cata = new Catalogue();

        String requete = "SELECT * FROM catalogue where id='"+id+"';";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
           while (rs.next()) {
             
                cata.setNom(rs.getString(2));
                cata.setLien(rs.getString(3));}
            return cata;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des services " + ex.getMessage());
            return null;
        }
    }
       public int trouverIdCatalogueParNom(String nom) {

        String requete = "SELECT id FROM catalogue WHERE nom=?";
        int id_C=0;
        try {
            PreparedStatement statement = cnx.prepareStatement(requete);
            statement.setString(1, nom);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                id_C=rs.getInt(1);
                idCatalogue =id_C;
                return id_C;
            }

        } catch (SQLException ex) {
            //System.err.println("erreur de recherche");
            ex.printStackTrace();
        }
        return id_C;
    }
       

      
}
