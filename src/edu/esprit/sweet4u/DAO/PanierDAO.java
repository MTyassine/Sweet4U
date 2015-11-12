/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.DAO;

import static com.oracle.jrockit.jfr.ContentType.StackTrace;
import edu.esprit.sweet4u.GUI.PanierModel;
import edu.esprit.sweet4u.entites.Article;
import edu.esprit.sweet4u.entites.ArticlePanier;
import edu.esprit.sweet4u.entites.Panier;
import edu.esprit.sweet4u.util.MyConnection;
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
 * @author WiKi
 */
public class PanierDAO {

    String sql;
    Connection conn;
    Statement state;
    static int idArticle;

    public PanierDAO() {

        conn = MyConnection.getInstance();
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public int rechercherIdArticlePanier(ArticlePanier a){
     int id=0;
        sql = "SELECT * FROM unecommande WHERE nom='" + a.getArt().getNom()+"'";
        System.out.println(sql);

        try {

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
             id=rs.getInt(1);
                a.setId_ArticlePanier(rs.getInt(1));

            }}catch (SQLException ex) {
                
                System.out.println("Erreur à la recherche d'id");
            }
        
return id;
}
    public void modifierQuantite(String nom, float qte) {     
        Panier pan = new Panier();
        List<ArticlePanier> liste = new ArrayList<ArticlePanier>();
        liste = pan.getListeArtPan();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getArt().getNom().equals(nom)) {
                liste.get(i).setQuantite(qte);

                System.out.println(nom);
                System.out.println(qte);
            }
        }
    }
   public void supprimerArticleDuPanier(String nom){
        Panier pan = new Panier();
        List<ArticlePanier> liste = new ArrayList<ArticlePanier>();
        liste = pan.getListeArtPan();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getArt().getNom().equals(nom)) {
                liste.remove(i);
            }
   } 
   }
 
               public void ajouterCommande(ArticlePanier a){
      
            
            try {
                 
                sql ="INSERT INTO unecommande (id_c,id_rp,id_catalogue,id_article,nom,prix,prixPromo,quantite)VALUES("+1+","+a.getArt().getId_rp()+","+a.getArt().getIdCatalogue()+","+a.getArt().getId()+",'"+a.getArt().getNom()+"',"+a.getArt().getPrix()+","+a.getArt().getPrixPromo()+","+a.getQuantite()+")";
                state.executeUpdate(sql);
                
            } catch (SQLException ex) {
                
                System.out.println("ArticlePanier non ajouté");
            }
           
           
    }

               public Article findArticleById(int id) {

        Article art = new Article();
        sql = "SELECT * FROM article WHERE id=" + id;
try {

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {

                art.setId(rs.getInt(1));

                art.setNom(rs.getString(2));
                //System.out.println("nom lu="+art.getNom());
                art.setPrix(rs.getFloat(3));
                // System.out.println("prix lu="+art.getPrix());
                art.setPrixPromo(rs.getFloat(4));
                art.setIdCatalogue(rs.getInt(5));
            }
            return art;
           // art.toString();

        } catch (SQLException ex) {

            System.err.println("Erreur recherche article ds la base");
            return null;
        }
    }

    public int findArticleByNom(String nom) {
        String requete = "SELECT * FROM article WHERE nom ='" + nom + "'";
        int id_A = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                id_A = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur recherche");
        }
        idArticle = id_A; //  
        return id_A;
    }
   
}
