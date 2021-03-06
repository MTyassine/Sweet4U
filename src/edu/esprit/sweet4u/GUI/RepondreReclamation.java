/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.ReclamationDAO;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.Reclamation;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo-G510
 */
public class RepondreReclamation extends javax.swing.JFrame {

    /**
     * Creates new form RepondreReclamation
     */
    
    Reclamation r = new Reclamation(null, null, null, null);
    
    public RepondreReclamation() {
        initComponents();
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
        from = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        reponse = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        sujetMail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new ReclamationModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 161, 375, 275);

        from.setEditable(false);
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });
        getContentPane().add(from);
        from.setBounds(473, 11, 233, 20);

        reponse.setColumns(20);
        reponse.setRows(5);
        jScrollPane2.setViewportView(reponse);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(473, 179, 233, 66);

        jButton1.setText("Repondre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(473, 263, 79, 23);

        sujetMail.setEditable(false);
        getContentPane().add(sujetMail);
        sujetMail.setBounds(473, 49, 233, 20);

        message.setEditable(false);
        message.setColumns(20);
        message.setRows(5);
        message.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(message);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(473, 77, 233, 96);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zeineb\\Desktop\\pattiserie\\12131.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 930, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            
        
        try {
                  
        
        Personne fromP = new Personne(); 
        fromP.setLogin("web-master@sweet4u.com");
        //Personne toP = new Personne();
        //toP.setLogin("mouhamedtahayassine.foudhaili@esprit.tn");
        
        ReclamationDAO rdao = new ReclamationDAO();
        Reclamation r2 = new Reclamation(null, null, null, null);
        r2.setEmeteur(fromP);
        r2.setDestinataire(r.getEmeteur());
        r2.setSujet(r.getSujet()); // a ajuter
        r2.setContenu(reponse.getText());
        
        rdao.ajouterReclamation(r2);
        
        JOptionPane.showMessageDialog(rootPane, "Reponse Envoyer !!!");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, " Veuillez choisir un catalogue ");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String nom;
            String prenom ;
            String sujet ;
        
        int rowS = jTable1.getSelectedRow();
            nom = jTable1.getModel().getValueAt(rowS, 0).toString();
            prenom = jTable1.getModel().getValueAt(rowS, 1).toString();
            sujet = jTable1.getModel().getValueAt(rowS, 2).toString();
            
            ReclamationDAO rdao = new ReclamationDAO();
            
            
            
            r = rdao.ChercherReclamation(nom, prenom, sujet);
            
            from.setText(r.getEmeteur().getLogin());
            sujetMail.setText(sujet);
            message.setText(r.getContenu());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(RepondreReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepondreReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepondreReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepondreReclamation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepondreReclamation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea message;
    private javax.swing.JTextArea reponse;
    private javax.swing.JTextField sujetMail;
    // End of variables declaration//GEN-END:variables
}
