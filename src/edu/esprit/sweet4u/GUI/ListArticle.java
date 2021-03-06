/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.ArticleDAO;
import edu.esprit.sweet4u.DAO.PanierDAO;
import edu.esprit.sweet4u.entites.Article;
import edu.esprit.sweet4u.entites.ArticlePanier;
import edu.esprit.sweet4u.entites.Panier;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Nassoura
 */
public class ListArticle extends javax.swing.JFrame {

    /**
     * Creates new form ListArticle
     */
    int id_C;
     AbstractTableModel model;
    public ListArticle() {
        initComponents();
    }

    public ListArticle(int idc) {
        initComponents();
        this.id_C=idc;
        
         RefineryUtilities.centerFrameOnScreen(this);
         model=(AbstractTableModel)jTable1.getModel();
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Retour = new javax.swing.JButton();
        ajouterAuPanier = new javax.swing.JButton();
        Commenter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new tablArticle());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 246, 710, 240);

        Retour.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\retour.png")); // NOI18N
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });
        getContentPane().add(Retour);
        Retour.setBounds(30, 640, 110, 40);

        ajouterAuPanier.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\ajouter au panier.png")); // NOI18N
        ajouterAuPanier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterAuPanierActionPerformed(evt);
            }
        });
        getContentPane().add(ajouterAuPanier);
        ajouterAuPanier.setBounds(460, 510, 190, 50);

        Commenter.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\Sans titre - 1.png")); // NOI18N
        Commenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommenterActionPerformed(evt);
            }
        });
        getContentPane().add(Commenter);
        Commenter.setBounds(190, 510, 170, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\12131.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -20, 830, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        // TODO add your handling code here:
        ListCatalogue list=new ListCatalogue();
        list.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_RetourActionPerformed

    private void ajouterAuPanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterAuPanierActionPerformed
        RefineryUtilities.centerFrameOnScreen(this);
        try {
          // PanierModel pModel = new PanierModel();
              Panier pan=new Panier();
              
            PanierDAO pDAO = new PanierDAO();
            String nom = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
           // System.out.println("nom=" + nom);
            int id = pDAO.findArticleByNom(nom);
           // System.out.println("id="+id);
            Article art = pDAO.findArticleById(id);
           // art.toString();
            ArticlePanier artPan = new ArticlePanier(art);
           // System.out.println(artPan);
            //pan.getListeArtPan().add(artPan);
            pan.ajouterAuPanier(artPan); 
           // System.out.println( pan.getListeArtPan());
 AfficherPanier Panier = new AfficherPanier(); //pour ouvrir la page panier

            this.setVisible(false);
            Panier.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(rootPane, " Erreur d'ouverture du Panier ");
        }
    }//GEN-LAST:event_ajouterAuPanierActionPerformed

    private void CommenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommenterActionPerformed
         ArticleDAO artdao= new ArticleDAO();
        int row = jTable1.getSelectedRow();
            String articlesel = jTable1.getModel().getValueAt(row, 0).toString();
          this.setVisible(false);
        new Commentaires( artdao.trouverIdArticleParNom(articlesel)).setVisible(true);
    }//GEN-LAST:event_CommenterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListArticle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Commenter;
    private javax.swing.JButton Retour;
    private javax.swing.JButton ajouterAuPanier;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
