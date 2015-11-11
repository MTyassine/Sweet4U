/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.ResponsablePatisserie;
import edu.esprit.sweet4u.util.MyConnection;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zeineb
 */
public class ResponsablePatisserieDAO implements IResponsablePatisserieDAO{
     String sql;
    Connection conn;
    Statement state;
    

    public ResponsablePatisserieDAO() {
       conn = MyConnection.getInstance();
       try {
            state =  conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

    @Override
    public void insertResponsablePatisserie(ResponsablePatisserie rp) {
         
 PersonneDAO p = new PersonneDAO();
        int idP = -1;
        
        p.insertPersonne( rp);
        
        try {
            
            
            sql ="SELECT MAX(id) FROM personne";
            ResultSet result = state.executeQuery(sql);
            if (result.next())
                idP = parseInt(result.getObject(1).toString());
            
            
            sql ="INSERT INTO responsable_patissier (patisserie,id_p)VALUES('"+rp.getNom_patisserie()+"','"+idP+"')";
            state.executeUpdate(sql);
            
            System.out.println("Patissié ajouter avec succée");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
            System.out.println("Patissié NON Ajouter !!!");
        }
           }

        public ResponsablePatisserie FindResponsableByLogin(int id) {

        String requete = "SELECT * FROM responsable_patissier WHERE id_p=?";
        ResponsablePatisserie d = null;
        try {
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                d = new ResponsablePatisserie();
                d.setId(rs.getInt(1));
                d.setNom_patisserie(rs.getString(2));
                //d.setAdresse_Patisserie(rs.getString(3));
            }

        } catch (SQLException ex) {
            //System.err.println("erreur de recherche");
            ex.printStackTrace();
        }
        return d;
    }

    
    @Override
    public void updateResponsablePatisserie(ResponsablePatisserie rp, int id) {
        
        PersonneDAO P = new PersonneDAO();
        Personne p1= new Personne ();
        p1.setNom(rp.getNom());
         p1.setPrenom(rp.getPrenom());
         p1.setAdresse(rp.getAdresse());
         p1.setDateNaissance(rp.getDateNaissance());
         p1.setCin(rp.getCin());
         p1.setLogin(rp.getLogin());
         p1.setPwd(rp.getPwd());
         P.updatePersonne(p1, id);
         String requete ="update responsable_patissier SET nom_patisserie=? ,adresse_patisserie=? where id_p= "+id;
         try {
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setString(1,rp.getNom_patisserie());
            //statement.setString(2, rp.getAdresse_Patisserie());
            statement.executeUpdate();
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteResponsablePatisserie(ResponsablePatisserie rp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public int calculNombreResponsable(){
        String requete = "SELECT count(*) FROM 	responsable_patissier ";
        int nombreResponsable = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               nombreResponsable=rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreResponsable;
    }
     
     // ajouter par MT Yassine Foudhaili
     
     public ResponsablePatisserie RechercherResponsable(int id) {

        String requete = "SELECT * FROM responsable_patissier WHERE id_p=?";
        ResponsablePatisserie d = new ResponsablePatisserie();
        try {
            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                
                d.setId(rs.getInt(1));
                d.setNom_patisserie(rs.getString(2));
                //d.setAdresse_Patisserie(rs.getString(3));
            }

        } catch (SQLException ex) {
            //System.err.println("erreur de recherche");
            ex.printStackTrace();
        }
        return d;
    }
     
    }

    
    
    

