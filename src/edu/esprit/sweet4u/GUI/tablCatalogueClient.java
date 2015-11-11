
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.CatalogueD;
import edu.esprit.sweet4u.entites.Catalogue;
import java.util.List;
import javax.swing.table.AbstractTableModel;








public class tablCatalogueClient  extends AbstractTableModel{
    
     
      List<Catalogue> catalogue ;
    String[]entetes = {"Nom"};
    
     public tablCatalogueClient(){
         catalogue = new CatalogueD().afficherLesCatalogues();
        
    } 
   
    
      @Override
    public int getRowCount() {
        return catalogue.size();
    }

    
      @Override
    public int getColumnCount() {
        return entetes.length;
    }

    
      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
                case 0:
                return catalogue.get(rowIndex).getNom();
                  
                default:
                throw new IllegalArgumentException();
        }
    }
      @Override
                    public String getColumnName(int column){
            return entetes[column];
    }

    
    
    
    
    
}
