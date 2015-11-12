/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.CommandeDAO2;
import edu.esprit.sweet4u.entites.ArticlePanier;
import edu.esprit.sweet4u.entites.Commande;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WiKi
 */

public class DetailsCommandeModel extends AbstractTableModel{
      ArrayList<ArticlePanier> maliste;
Commande com=new Commande();

    String[] entete={"Nom","Prix","PrixPromo","Quantité"};
   

    public DetailsCommandeModel() {
        //CommandeDAO cdao=new CommandeDAO();
        maliste=new ArrayList<ArticlePanier>();
        
       //maliste=cdao.afficherDetailsCommandes(id);
        maliste=com.getListeArtPan();
    }

    @Override
    public int getRowCount() { // nb lignes du tab
        return maliste.size();
       
    }

    @Override
    public int getColumnCount() {
          return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
         
          
          case 0:
              return maliste.get(rowIndex).getArt().getNom();
          case 1:
              return maliste.get(rowIndex).getArt().getPrix();
          case 2:
              return maliste.get(rowIndex).getArt().getPrixPromo();    
          case 3:
              return maliste.get(rowIndex).getQuantite();      
          default:return null;  
          
         
        
          
          
      }  
    }
    
    
    
    
    @Override
    public String getColumnName(int column){
        return entete[column];
    }
    
}

