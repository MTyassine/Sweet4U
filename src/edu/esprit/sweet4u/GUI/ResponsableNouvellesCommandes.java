/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.CommandeDAO2;
import edu.esprit.sweet4u.entites.ArticlePanier;
import edu.esprit.sweet4u.entites.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author WiKi
 */
public class ResponsableNouvellesCommandes extends javax.swing.JFrame {
  AbstractTableModel model;
   AbstractTableModel model2;
  
  
    /**
     * Creates new form ResponsableNouvellesCommandes
     */
    public ResponsableNouvellesCommandes() {
        initComponents();
          model = (AbstractTableModel) jTable1.getModel();
          model2=(AbstractTableModel) jTable2.getModel();

        RefineryUtilities.centerFrameOnScreen(this);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        accepter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new ResponsableNvllesCommandesModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 199, 375, 202);

        jTable2.setModel(new DetailsCommandeModel());
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(542, 429, 369, 108);

        accepter.setText("accepter");
        accepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepterActionPerformed(evt);
            }
        });

        jButton2.setText("refuser");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(accepter)
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accepter)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(542, 543, 369, 89);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\12131.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 1010, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      //  this.setVisible(false);
        
        DetailsCommandeModel detCom = new  DetailsCommandeModel();
            jTable2.setModel(detCom);
          //  detCom.fireTableDataChanged();
            detCom.fireTableRowsUpdated(0,20);
            model2 = (AbstractTableModel) jTable2.getModel(); 
       
//          ResponsableNouvellesCommandes details= new ResponsableNouvellesCommandes();
//         
//            details.setVisible(true);
        RefineryUtilities.centerFrameOnScreen(this);
         Commande cmd=new Commande();
         CommandeDAO2 cdao=new CommandeDAO2();
         try { 
              
            int rowS = jTable1.getSelectedRow();
            String strId = jTable1.getModel().getValueAt(rowS, 0).toString();
            int id=Integer.parseInt(strId);
           
             System.out.println(strId);
          String chaine=cdao.afficherDetailsCommandes(id);  
             System.out.println(chaine);
          
             String[] partsArticles; // tableau de chaines

            partsArticles = chaine.split(","); // liste de Id

            //Commande cmde = new Commande();
           // String partsArticle : partsArticles
            for (int i=1;i<partsArticles.length;i++) {
                //System.out.println(partsArticle);
                int id_article = Integer.parseInt(partsArticles[i]);
                ArticlePanier art=new ArticlePanier();
                art=cdao.chercherUneCommandeParId(id_article);
               cmd.ajouterAuPanier(art);

            }
            
             System.out.println(cmd.getListeArtPan());
           // art.toString();           
           // System.out.println(artPan);
            //pan.getListeArtPan().add(artPan);
            //com.ajouterAuPanier(artPan); 
 
          
              
        } catch (Exception e) {
             System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, " erreur de recuperation de détails ");
             Logger.getLogger(CommandeDAO2.class.getName()).log(Level.SEVERE,null,e);
        }
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void accepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accepterActionPerformed
       int rowS = jTable1.getSelectedRow();
            String strId = jTable1.getModel().getValueAt(rowS, 0).toString();
            int id=Integer.parseInt(strId);
        CommandeDAO2 cdao=new CommandeDAO2(); 
        cdao.ApprobationOUI(id);
         ResponsableNvllesCommandesModel detCom = new  ResponsableNvllesCommandesModel();
            jTable1.setModel(detCom);
            detCom.fireTableDataChanged();
            model = (AbstractTableModel) jTable1.getModel(); 
    }//GEN-LAST:event_accepterActionPerformed

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
            java.util.logging.Logger.getLogger(ResponsableNouvellesCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResponsableNouvellesCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResponsableNouvellesCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResponsableNouvellesCommandes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResponsableNouvellesCommandes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accepter;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
