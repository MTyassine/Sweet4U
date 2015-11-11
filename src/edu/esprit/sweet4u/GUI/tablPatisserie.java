
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.PatisserieDAO;
import edu.esprit.sweet4u.entites.ResponsablePatisserie;

import java.util.List;
import javax.swing.table.AbstractTableModel;








public class tablPatisserie  extends AbstractTableModel{
    
     
      List<ResponsablePatisserie> patisserie ;
    String[]entetes = {"Nom"};
    
     public tablPatisserie(){
         patisserie = new PatisserieDAO().afficherLesPatisseries();
        
    } 
   
    
      @Override
    public int getRowCount() {
        return patisserie.size();
    }

    
      @Override
    public int getColumnCount() {
        return entetes.length;
    }

    
      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
                case 0:
                return patisserie.get(rowIndex).getNom_patisserie();
                  
                default:
                throw new IllegalArgumentException();
        }
    }
      @Override
                    public String getColumnName(int column){
            return entetes[column];
    }

    
    
    
    
    
}
