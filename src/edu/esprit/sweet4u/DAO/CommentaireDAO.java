/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.util.MyConnection;
import edu.esprit.sweet4u.entites.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ACER
 */
public class CommentaireDAO {
    Connection cnx;
    String requete;
        Statement state;

    public CommentaireDAO() {
        
        cnx = MyConnection.getInstance();
        try{
            state= cnx.createStatement();
        }catch (SQLException ex){
           Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("erreur !!!");
        }
        
    }

    public void ajouterCommentaire( Commentaire c) {
         
        try { 
             DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
           Date d = Date.from(Instant.now());
           String datestring = dateFormat.format(d);
         requete = "INSERT INTO commentaire ( id_p, id_article, date, commentaire) VALUES ("+c.getId_p()+","+ c.getId_a()+",'"+datestring+"','"+c.getCommentaire()+"')";
         state.executeUpdate(requete);
         
         
            System.out.println("insertion effectuée");
        }
        
        catch (SQLException ex){
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE,null,ex);
            
            System.err.println("erreur d'ajout");
        }
                
}
    public void modifierCommentaire ( Commentaire c, int id){
       String requete = "UPDATE commentaire set commentaire=? WHERE id=" + id;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, c.getCommentaire());
            st.executeUpdate();
            System.out.println("Modification effectuÃ©");
        } catch (SQLException ex) {
            System.err.println("Erreur de la modification");
        } 
        
    }
    
    public void supprimerCommentare (Commentaire c) {
        String requete = "DELETE FROM commentaire WHERE id=?";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, c.getId());
            st.executeUpdate();
            System.out.println("Suppression effectuÃ©");
        } catch (SQLException ex) {
            System.err.println("Erreur de la suppression");
        }
    }

     public Commentaire trouverCommentaireParId(int id) {
        String requete = "SELECT * FROM commentaire WHERE id=" + id;
        Commentaire c = null;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            c = new Commentaire();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setId_p(rs.getInt(2));
                c.setId_a(rs.getInt(3));
                c.setDatecom(rs.getString(4));
                c.setCommentaire(rs.getString(5));
                c.setSignalement(rs.getInt(6));
                c.setVisible(rs.getBoolean(7));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur recherche");
        }
        return c;
     }
      public Commentaire trouverCommentaireParTxt(String txt) {
        String requete = "SELECT * FROM commentaire WHERE commentaire ='" +txt+"'";
        Commentaire c = null;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            c = new Commentaire();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setId_p(rs.getInt(2));
                c.setId_a(rs.getInt(3));
                c.setDatecom(rs.getString(4));
                c.setCommentaire(rs.getString(5));
                c.setSignalement(rs.getInt(6));
                c.setVisible(rs.getBoolean(7));
            }
        } catch (SQLException ex) {
            System.err.println("");
        }
        return c;
     }
     
       public List<Commentaire> rechercherCommentaireParId_a(int id_a) {
        String requete = "SELECT * FROM commentaire WHERE id_article=" + id_a;
        Commentaire c = new Commentaire();
        List<Commentaire> cm;
        cm = new ArrayList<Commentaire>();
        
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete); 
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setId_p(rs.getInt(2));
                c.setId_a(rs.getInt(3));
                c.setDatecom(rs.getString(4));
                c.setCommentaire(rs.getString(5));
                c.setSignalement(rs.getInt(6));
                c.setVisible(rs.getBoolean(7));
            cm.add(c);
          
            }System.out.println(cm);
            return cm;
        } catch (SQLException ex) {
            System.err.println("Erreur recherche");
       return null;
        }
       
     }
       
public List<Commentaire> afficherCommentaire(int a){
    List<Commentaire> maListe;
        maListe = new ArrayList<Commentaire>();
    String requete = "select * from commentaire WHERE Visible=TRUE AND Id_article="+a;
    Statement st;
        try {
            st =cnx.createStatement();
            ResultSet result = st.executeQuery(requete);
            while(result.next()){
            Commentaire c=new Commentaire(0,0,0, null);
                c.setId(result.getInt(1));
                c.setId_p(result.getInt(2));
                c.setId_a(result.getInt(3));
                c.setDatecom(result.getString(4));
                c.setCommentaire(result.getString(5));
                c.setSignalement(result.getInt(6));
            
             maListe.add(c);
            }
            return(maListe);
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
    
    return maListe;
    }
public void signalerCommentaire ( int id){
       String requete = "UPDATE commentaire set signalement=signalement+1 WHERE id=" + id;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            //st.setInt(1, c.getSignalement()+1);
            st.executeUpdate();
            System.out.println("Modification effectuÃ©");
        } catch (SQLException ex) {
            System.err.println("Erreur de la modification");
        } 
        
    }

    public List<Commentaire> afficherCommentairesSignalés() {
        //To change body of generated methods, choose Tools | Templates.
    List<Commentaire> maListe;
        maListe = new ArrayList<Commentaire>();
    String requete = "select * from commentaire WHERE Visible=TRUE AND Signalement<>0";
    Statement st;
        try {
            st =cnx.createStatement();
            ResultSet result = st.executeQuery(requete);
            while(result.next()){
            Commentaire c=new Commentaire(0,0,0, null);
           c.setId(result.getInt(1));
                c.setId_p(result.getInt(2));
                c.setId_a(result.getInt(3));
                c.setDatecom(result.getString(4));
                c.setCommentaire(result.getString(5));
                c.setSignalement(result.getInt(6));
                c.setVisible(result.getBoolean(7));
             maListe.add(c);
            }
            return(maListe);
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
    
    return maListe;
    }
    
}

   