/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Patisserie;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.ResponsablePatisserie;
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
 * @author Lenovo-G510
 */
public class AdresseDAO {
    
        String sql;
    Connection conn;
    Statement state;
    Personne pc;
    
    public AdresseDAO(){
    conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        pc = PersonneConenction.getInstance(); 

    }
    
    public void ajouterPatisserie(Patisserie p){
        
        ResponsablePatisserie rp = new ResponsablePatisserie();
        ResponsablePatisserieDAO rpdao = new ResponsablePatisserieDAO();
        
        rp = rpdao.FindResponsableByLogin(pc.getId());
        
        int id_pr = rp.getId();
        
        try {
            sql ="INSERT INTO patisserie (id_rp,delegation,adresse,code_postal)VALUES("+p.getId_rp()+",'"+p.getDelegation()+"','"+p.getAdresse()+"',"+p.getCodePostal()+")";
            System.out.println(sql);
            state.executeUpdate(sql);
            
            System.out.println("patisserie ajouter");
            
        } catch (SQLException ex) {
            System.out.println("patisserie NON eajouter !!!");
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ajouterCoord(Patisserie p){
        
        ResponsablePatisserie rp = new ResponsablePatisserie();
        ResponsablePatisserieDAO rpdao = new ResponsablePatisserieDAO();
        
        rp = rpdao.FindResponsableByLogin(pc.getId());
        
        int id_pr = rp.getId();
        
        try {
            sql ="UPDATE patisserie SET x ="+p.getX()+" , y = "+p.getY()+" WHERE id=MAX(id)";
            System.out.println(sql);
            state.executeUpdate(sql);
            
            System.out.println("coordonnée ajouter");
            
        } catch (SQLException ex) {
            System.out.println("coordonnée NON eajouter !!!");
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Patisserie ChercherPatisserie (String delegation, String adresse, int code_postal){
    
    Patisserie p = new Patisserie(-1, code_postal, delegation, adresse);
    
    sql ="SELECT * FROM patisserie WHERE code_postal ="+code_postal+" AND delegation = '"+delegation+"' AND adresse = '"+adresse+"'" ;
              
        try {
        ResultSet result = state.executeQuery(sql);
                
         if (result.next()) {

                p.setId(result.getInt(1));
                p.setId_rp(result.getInt(2));
                //p.setDelegation(result.getString(3));
                //p.setAdresse(result.getString(4));
                //p.setCodePostal(result.getInt(5));
                
            }
            return p;
            }catch (SQLException ex) {
            System.err.println("Erreur de recuperation de la patisserie");
    
    }
    
    return p;
        
    }
    
    public void ModifierPatisserie (Patisserie p){
    
        try {
            sql ="UPDATE patisserie SET code_postal ="+p.getCodePostal()+" , delegation = '"+p.getDelegation()+"' , adresse = '"+p.getAdresse()+"' WHERE id="+p.getId();
            state.executeUpdate(sql);
            
            System.out.println("Adresse Patisserie Modifier");
            
        } catch (SQLException ex) {
            System.out.println("Adresse Patisserie NON Modifier !!!");
        }      
    
    }
    
    public void SuprimerPatisserie (Patisserie p){
    
        try {
            sql ="DELETE FROM patisserie WHERE id="+p.getId();
            state.executeUpdate(sql);
            
            System.out.println("Patisserie Suprimer");
            
        } catch (SQLException ex) {
            System.out.println("Patisserie NON Suprimer !!!");
        }      
    
    }
    
    public List<Patisserie> afficherPatisserie(int id_rp){
    
        List<Patisserie> maListe = new ArrayList<Patisserie>();
        sql ="SELECT * FROM patisserie WHERE id_rp = "+id_rp; // a ajuster suivant l'affichage de la patissrie
        
        try {

            ResultSet result = state.executeQuery(sql);
;
            
            while (result.next()) {
                Patisserie p = new Patisserie(-1, -1, null, null);
                
                p.setId(result.getInt(1));
                p.setId_rp(result.getInt(2));
                p.setDelegation(result.getString(3));
                p.setAdresse(result.getString(4));
                p.setCodePostal(result.getInt(5));
                maListe.add(p);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return maListe;
        
    }
    
    public List<Patisserie> ChercherPatisserieInst(String msg){
    
        List<Patisserie> maListe = new ArrayList<Patisserie>();
        sql ="SELECT * FROM patisserie WHERE delegation LIKE '%"+msg+"%' OR adresse LIKE '%"+msg+"%'";
        
        try {

            ResultSet result = state.executeQuery(sql);
;
            
            while (result.next()) {
                Patisserie p = new Patisserie(-1, -1, null, null);
                
                p.setId(result.getInt(1));
                p.setId_rp(result.getInt(2));
                p.setDelegation(result.getString(3));
                p.setAdresse(result.getString(4));
                p.setCodePostal(result.getInt(5));
                maListe.add(p);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return maListe;
        
    }
    
    public ArrayList<Patisserie> ChercherPatisserieParId(int id_rp){
    
        ArrayList<Patisserie> maListe = new ArrayList<Patisserie>();
        sql ="SELECT * FROM patisserie WHERE id_rp ="+id_rp;
        
        try {

            ResultSet result = state.executeQuery(sql);
;
            
            while (result.next()) {
                Patisserie p = new Patisserie(-1, -1, null, null);
                
                p.setId(result.getInt(1));
                p.setId_rp(result.getInt(2));
                p.setDelegation(result.getString(3));
                p.setAdresse(result.getString(4));
                p.setCodePostal(result.getInt(5));
                maListe.add(p);
            }
            return maListe;
            }catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return maListe;
        
    }
    
}
