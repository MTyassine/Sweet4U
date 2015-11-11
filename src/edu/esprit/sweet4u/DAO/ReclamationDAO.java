
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.DAO.PersonneDAO;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.Reclamation;
import edu.esprit.sweet4u.util.MailCon;


import edu.esprit.sweet4u.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReclamationDAO {
    
    String sql;
    Connection conn;
    Statement state;
    
    public ReclamationDAO(){
    conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public void ajouterReclamation(Reclamation r){
        

        //MailConstruction envoyer = new MailConstruction(r);
        
        MailCon mail = new MailCon(r);
        //envoyer.mail();//r);
        
        try {
            sql ="INSERT INTO reclamation (id_from,id_to,sujet,contenu)VALUES("+r.getEmeteur().getId()+","+r.getDestinataire().getId()+",'"+r.getSujet()+"','"+r.getContenu()+"')";
            state.executeUpdate(sql);
            
            System.out.println("Reclamation envoyer");
            
        } catch (SQLException ex) {
            System.out.println("Reclamation NON envoyer !!!");
        }
        
    }
    
    public void repondreReclamation(Reclamation r){
        

        //MailConstruction envoyer = new MailConstruction(r);
        
        MailCon mail = new MailCon(r);
        //envoyer.mail();//r);
        
        /*try {
            sql ="INSERT INTO reclamation (id_from,id_to,sujet,contenu)VALUES("+r.getEmeteur().getId()+","+r.getDestinataire().getId()+",'"+r.getSujet()+"','"+r.getContenu()+"')";
            state.executeUpdate(sql);
            
            System.out.println("Reclamation envoyer");
            
        } catch (SQLException ex) {
            System.out.println("Reclamation NON envoyer !!!");
        }*/
        
    }
    
    public Reclamation ChercherReclamation(String nom, String prenom, String sujet){
    
        Personne p = new Personne();
        PersonneDAO pdao = new PersonneDAO();
        p = pdao.ChercherPersonneByNom(nom, prenom);
        
        int idTo = 0;
        Personne to = new Personne();
        
        Reclamation r = new Reclamation(p, null, sujet, null);
        
        sql ="SELECT * FROM reclamation WHERE id_from ="+p.getId()+" AND sujet = '"+sujet+"'" ;
              
        try {
        ResultSet result = state.executeQuery(sql);
                
         if (result.next()) {
            
            idTo = result.getInt(3);
            to = pdao.ChercherPersonneByID(idTo);
            r.setDestinataire(to);
            r.setContenu(result.getString(5));
                
            }
            return r;
            }catch (SQLException ex) {
            System.err.println("Erreur de recuperation de la personne");
    
    }
    return r;
        
        
        
    
    }
    
    public List<Reclamation> afficherReclamation(){
    
        List<Reclamation> maListe = new ArrayList<Reclamation>();
        sql ="SELECT * FROM reclamation";
        
        try {
            //st = conn.createStatement();
            
            ResultSet result = state.executeQuery(sql);
            
            PersonneDAO pdao = new PersonneDAO();
            
            Personne from = new Personne();
        
            Personne to = new Personne();
            
            while (result.next()) {
                Reclamation r = new Reclamation(null, null, null, null);
                
                from = pdao.ChercherPersonneByID(result.getInt(2));
                to = pdao.ChercherPersonneByID(result.getInt(3));
                
                r.setEmeteur(from);
                r.setDestinataire(to);
                
                r.setSujet(result.getString(4));
                r.setContenu(result.getString(5));
                maListe.add(r);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return maListe;
        
    }
    
}
