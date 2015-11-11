/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;
import edu.esprit.sweet4u.DAO.AdresseDAO;
import edu.esprit.sweet4u.DAO.ResponsablePatisserieDAO;
import edu.esprit.sweet4u.GUI.PatisserieModel;
import edu.esprit.sweet4u.entites.Patisserie;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.ResponsablePatisserie;
import edu.esprit.sweet4u.util.PersonneConenction;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo-G510
 */
public class AjouterPatisserie extends javax.swing.JFrame {

    /**
     * Creates new form AjouterPatisserie
     */
    
    Patisserie pRechercher = new Patisserie(-1, -1, null, null);
    Personne  pc = PersonneConenction.getInstance();
    
    public AjouterPatisserie() {
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

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        codePostal = new javax.swing.JTextField();
        delegation = new javax.swing.JComboBox();
        adresse = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        suprimer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new PatisserieModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        delegation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kébili", "La Manouba", "Le Kef", "Mahdia", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana ", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan" }));
        delegation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delegationActionPerformed(evt);
            }
        });

        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        suprimer.setText("Suprimer");
        suprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suprimerActionPerformed(evt);
            }
        });

        jLabel1.setText("Delegation");

        jLabel2.setText("Ciode Postal");

        jLabel3.setText("Adresse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delegation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(codePostal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(ajouter)
                .addGap(109, 109, 109)
                .addComponent(modifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(suprimer)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delegation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouter)
                    .addComponent(modifier)
                    .addComponent(suprimer))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delegationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delegationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delegationActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        
        AdresseDAO rdao = new AdresseDAO();
        Patisserie p = new Patisserie(-1, -1, null, null);
        
        String del = (String) delegation.getSelectedItem();
        p.setDelegation(del);
        p.setAdresse(adresse.getText());
        p.setCodePostal(Integer.parseInt(codePostal.getText()));
        
        ResponsablePatisserie rp = new ResponsablePatisserie();
        ResponsablePatisserieDAO rpdao = new ResponsablePatisserieDAO();
        rp = rpdao.RechercherResponsable(pc.getId());

        p.setId_rp(rp.getId());
        
        rdao.ajouterPatisserie(p);
        
        JOptionPane.showMessageDialog(rootPane, "Patisserie Ajouter !!!");
        
        AjouterPatisserie res = new AjouterPatisserie();
          
        res.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void suprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprimerActionPerformed
        
        AdresseDAO rdao = new AdresseDAO();
       
        
        rdao.SuprimerPatisserie(pRechercher);
        
        JOptionPane.showMessageDialog(rootPane, "Patisserie suprimer !!!");
        
    }//GEN-LAST:event_suprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        
        AdresseDAO rdao = new AdresseDAO();
        
        String del = (String) delegation.getSelectedItem();
        pRechercher.setDelegation(del);
        pRechercher.setAdresse(adresse.getText());
        pRechercher.setCodePostal(Integer.parseInt(codePostal.getText()));
        
        rdao.ModifierPatisserie(pRechercher);
        
        JOptionPane.showMessageDialog(rootPane, "Patisserie Modifier !!!");
        
    }//GEN-LAST:event_modifierActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String del;
        String adr ;
        String codeP ;
        
        int rowS = jTable1.getSelectedRow();
            del = jTable1.getModel().getValueAt(rowS, 0).toString();
            adr = jTable1.getModel().getValueAt(rowS, 1).toString();
            codeP = jTable1.getModel().getValueAt(rowS, 2).toString();
            
        AdresseDAO rdao = new AdresseDAO();
        
            
        pRechercher.setDelegation(del);
        pRechercher.setAdresse(adr);
        pRechercher.setCodePostal(Integer.parseInt(codeP));
        
        pRechercher = rdao.ChercherPatisserie(pRechercher.getDelegation(), pRechercher.getAdresse(), pRechercher.getCodePostal());
        
            
            delegation.setSelectedItem(del);//r.getEmeteur().getMail());
            adresse.setText(adr);
            codePostal.setText(codeP);//r.getContenu());
    
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
            java.util.logging.Logger.getLogger(AjouterPatisserie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterPatisserie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterPatisserie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterPatisserie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterPatisserie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField codePostal;
    private javax.swing.JComboBox delegation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton modifier;
    private javax.swing.JButton suprimer;
    // End of variables declaration//GEN-END:variables
}
