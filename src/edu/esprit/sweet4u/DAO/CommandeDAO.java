/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.esprit.sweet4u.entites.Commande;
import edu.esprit.sweet4u.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//package edu.esprit.sweet4u.DAO;

/**
 *
 * @author WiKi
 */

//public class CommandeDAO {
    
   // Connection cnx;

   // public CommandeDAO() {
   //     cnx = MyConnection.getInstance();
   // }

   // public void ajouterCommande(Commande cmde) {
    //    boolean statutPayement;
   // boolean statutValidation;
   // Article [] listeArticle;
   // String modePayement;
   // String modeLivraisant;
   // float pritTotal =0f;
   // static int nbCommande;
   // static float chiffreAffaire;
      //  String requete = "INSERT INTO commande (statutPayement,statutValidation,listeArticle,modePayement,modeLivraisant,) VALUES (?,?)";
       // try {
          //  PreparedStatement st = cnx.prepareStatement(requete);
          //  st.setString(1, p.getNom());
           // st.setString(2, p.getPrenom());
           // st.executeUpdate();
           // System.out.println("Insertion effectuÃ©");
        //} catch (SQLException ex) {
          //  ex.printStackTrace();
            //System.err.println("Erreur d'ajout");
      //  }
    //}

  //  public void updatePersonne(Personne p, int id) {
      //  String requete = "UPDATE personne set nom=?,prenom=? WHERE id=" + id;
       // try {
          //  PreparedStatement st = cnx.prepareStatement(requete);
           // st.setString(1, p.getNom());
           // st.setString(2, p.getPrenom());
           // st.executeUpdate();
           // System.out.println("Modification effectuÃ©");
       // } catch (SQLException ex) {
          //  System.err.println("Erreur de la modification");
      //  }
    //}

   // public void deletePersonne(Personne p) {
      //  String requete = "DELETE FROM personne WHERE id=?";
      //  try {
       //     PreparedStatement st = cnx.prepareStatement(requete);
         //   st.setInt(1, p.getId());
          //  st.executeUpdate();
          //  System.out.println("Suppression effectuÃ©");
        //} catch (SQLException ex) {
        //    System.err.println("Erreur de la suppression");
       // }
   // }

   // public Personne findPersonneById(int id) {
     //   String requete = "SELECT * FROM personne WHERE id=" + id;
      //  Personne p = null;
      //  try {
        //    Statement st = cnx.createStatement();
         //   ResultSet rs = st.executeQuery(requete);
          //  p = new Personne();
           // while (rs.next()) {
            //    p.setId(rs.getInt(1));
              //  p.setNom(rs.getString(2));
              //  p.setPrenom(rs.getString(3));
          //  }
      //  } catch (SQLException ex) {
       //     System.err.println("Erreur recherche");
      //  }
      //  return p;
  //  }

   // public List<Personne> afficherPersonnes() {
      //  List<Personne> maListe = new ArrayList<>();
      //  String requete = "SELECT * FROM personne";
       // Statement st;
       // try {
         //   st = cnx.createStatement();
            
          //  ResultSet rs = st.executeQuery(requete);
          //  while (rs.next()) {
             //   Personne p = new Personne();
            //    p.setId(rs.getInt(1));
             //   p.setNom(rs.getString(2));
             //   p.setPrenom(rs.getString(3));
              //  maListe.add(p);
          //  }
          //  return maListe;
           // }catch (SQLException ex) {
           // System.err.println("Erreur d'affichage de la liste");
      //  }
      //  return null;
      //  }

    
//}



