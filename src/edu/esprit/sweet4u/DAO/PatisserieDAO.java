/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Catalogue;

import edu.esprit.sweet4u.entites.ResponsablePatisserie;
import edu.esprit.sweet4u.util.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nassoura
 */
public class PatisserieDAO {
      Connection cnx;
       public PatisserieDAO() {
        
        cnx = MyConnection.getInstance();
    }
     public ArrayList<ResponsablePatisserie> afficherLesPatisseries() {
         
        ArrayList<ResponsablePatisserie> maListe = new ArrayList<>();
        String requete = "SELECT * FROM responsable_patissier";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
             ResponsablePatisserie rp = new ResponsablePatisserie();
            rp.setId(rs.getInt(1));
            rp.setNom_patisserie(rs.getString(2));
            
            maListe.add(rp);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return maListe;
        }
    
}
