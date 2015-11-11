/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Personne;
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

/**
 *
 * @author Lenovo-G510
 */
public class PersonneDAO implements IPersonneDAO {

    String sql;
    Connection conn;
    Statement state;

    public PersonneDAO() {

        conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int returnID(Personne p, String login) {
            int idPersonne = 0;
        try {
        
            sql = "select id from personne where login =" + login;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                idPersonne = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();

        }
        return idPersonne;

    }

    @Override
    public void insertPersonne(Personne p) {

        try {
            sql = "INSERT INTO personne (nom,prenom,adresse,date_naissance,cin,login,pwd)VALUES('" + p.getNom() + "','" + p.getPrenom() + "','" + p.getAdresse() + "','" + p.getDateNaissance() + "','" + p.getCin() + "','" + p.getLogin() + "','" + p.getPwd() + "')";
            state.executeUpdate(sql);

            System.out.println("Personne ajouter avec succée");

        } catch (SQLException ex) {
            System.out.println("Personne NON Ajouter !!!");
        }

    }

    public void updatePersonne(Personne p, int id) {

        String requete = "UPDATE personne set nom=?,prenom=?,adresse=?,cin=?,login=?,pwd=?  WHERE id=" + id;
        try {
            PreparedStatement st = conn.prepareStatement(requete);
            st.setString(1, p.getNom());
            st.setString(2, p.getPrenom());
            st.setString(3, p.getAdresse());
            st.setInt(4, p.getCin());

            st.setString(5, p.getLogin());
            st.setString(6, p.getPwd());

            st.executeUpdate();
            System.out.println("Modification effectuee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void deletePersonne(Personne p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personne> afficherPersonnes() {
        List<Personne> maListe = new ArrayList<>();
        String requete = "SELECT * FROM personne";
        Statement st;
        try {
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Personne p = new Personne();

                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setAdresse(rs.getString(4));
                p.setCin(rs.getInt(5));
                p.setLogin(rs.getString(6));
                p.setPwd(rs.getString(7));

                maListe.add(p);
            }
            return maListe;
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return null;
    }

    @Override
    public Personne FindPersonneByLogin(String login) {

        String requete = "SELECT * FROM personne WHERE login=?";
        Personne d = null;
        try {
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                d = new Personne();
                d.setId(rs.getInt(1));
                d.setNom(rs.getString(2));
                d.setPrenom(rs.getString(3));
                d.setAdresse(rs.getString(4));
                d.setCin(rs.getInt(6));
                d.setLogin(rs.getString(7));
            }

        } catch (SQLException ex) {
            //System.err.println("erreur de recherche");
            ex.printStackTrace();
        }
        return d;
    }

//    public int retournerID(Personne p) {
//        String requete = "SELECT id FROM compte where nom=? ";
//        try {
//            PreparedStatement st = conn.prepareStatement(requete);
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                return rs.getInt("compte_id");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            //System.out.println("Erreur d'ajout");
//        }
//        return 0;
//    }

    public void MasquerPersonne(Personne P )
    {
        
    }
    
    // ajouter par MT Yassine Foudhaili
    
    public Personne ChercherPersonneByNom(String nom, String prenom){
        
        Personne p = new Personne();
        
        sql ="SELECT * FROM personne WHERE nom ='"+nom+"' AND prenom = '"+prenom+"'" ;
              
        try {
        ResultSet result = state.executeQuery(sql);
                
         if (result.next()) {

                p.setId(result.getInt(1));
                p.setNom(result.getString(2));
                p.setPrenom(result.getString(3));
                p.setAdresse(result.getString(4));
                //p.setDateNaissance(result.getString(5));
                p.setCin(result.getInt(6));
                p.setLogin(result.getString(7));

            }
            return p;
            }catch (SQLException ex) {
            System.err.println("Erreur de recuperation de la personne");
    
    }
    return p;
}
    
    //Ajouter par MT Yassine Foudhaili
    
    public Personne ChercherPersonneByID(int id){
        
        Personne p = new Personne();
        
        sql ="SELECT * FROM personne WHERE id ="+id ;
              
        try {
        ResultSet result = state.executeQuery(sql);
                
         if (result.next()) {

                p.setId(result.getInt(1));
                p.setNom(result.getString(2));
                p.setPrenom(result.getString(3));
                p.setAdresse(result.getString(4));
                //p.setDateNaissance(result.getString(5));
                p.setCin(result.getInt(6));

            }
            return p;
            }catch (SQLException ex) {
            System.err.println("Erreur de recuperation de la personne d'id :"+id);
    
    }
    return p;
}
}
