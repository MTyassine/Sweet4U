/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Client;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.util.MyConnection;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author Zeineb
 */
public class ClientDAO implements IClientDAO {

    String sql;
    Connection conn;
    Statement state;

    public ClientDAO() {
        conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int returnID2(int ida) {
        try {
            String requete = "SELECT id FROM responsable_patissier WHERE id_p=?";

            PreparedStatement statement = conn.prepareStatement(requete);
            statement.setInt(1, ida);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                System.out.println("aaaaaaaaaaaaaa");
                return 1;
            }
           
        } catch (SQLException ex) {
            ex.getMessage();

        }
        return -1;
    }

    @Override
    public void insertClient(Client c) {
        int idP = -1;

        PersonneDAO p = new PersonneDAO();

        p.insertPersonne(c);

        try {

            sql = "SELECT MAX(id) FROM personne";
            ResultSet result = state.executeQuery(sql);

            if (result.next()) {
                idP = parseInt(result.getObject(1).toString());
            }

            sql = "INSERT INTO client (id_p)VALUES('" + idP + "')";
            state.executeUpdate(sql);

            System.out.println("Client ajouter avec succée");

        } catch (SQLException ex) {
            System.out.println("Client NON Ajouter !!!");
        }

    }

    @Override
    public void updateClient(Client c, int id) {
        /* PersonneDAO p = new PersonneDAO() ;
         Personne p1=new Personne ();
         p1.setNom(c.getNom());
         p1.setPrenom(c.getPrenom());
         p1.setAdresse(c.getAdresse());
         p1.setDateNaissance(c.getDateNaissance());
         p1.setCin(c.getCin());
         p1.setLogin(c.getLogin());
         p1.setPwd(c.getPwd());
         p.updatePersonne(p1, id);
         String requete = "UPDATE client set  WHERE id_p= "+id;
         try {
         PreparedStatement st = conn.prepareStatement(requete);
           
           
         st.executeUpdate();
         System.out.println("Modification effectuee");
         } catch (SQLException ex) {
         System.err.println(ex.getMessage());
         }   */ }

    @Override
    public void deleteClient(Client c) {

    }
    
    public int calculNombreClient(){
        String requete = "SELECT count(*) FROM Client ";
        int nombreClient = 0;
        try {
            PreparedStatement statement = conn.prepareStatement(requete);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               nombreClient=rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombreClient;
    }
    
//      public List<Client> afficherClient() {
//        List<Client> maListe1 = new ArrayList<>();
//        String requete = "SELECT * FROM Client ";
//        Statement st;
//        try {
//            st = conn.createStatement();
//
//            ResultSet rs = st.executeQuery(requete);
//            while (rs.next()) {
//                Client c = new Client();
//
//                c.setNom(rs.getString(2));
//                c.setPrenom(rs.getString(3));
//                c.setAdresse(rs.getString(4));
//                c.setCin(rs.getInt(5));
//                c.setLogin(rs.getString(6));
//                c.setPwd(rs.getString(7));
//
//                maListe1.add(c);
//            }
//            return maListe1;
//        } catch (SQLException ex) {
//            System.err.println("Erreur d'affichage de la liste");
//        }
//        return null;
//    }

   
}
