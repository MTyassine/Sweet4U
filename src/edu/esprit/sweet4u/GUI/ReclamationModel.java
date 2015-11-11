
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.ReclamationDAO;
import edu.esprit.sweet4u.entites.Reclamation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReclamationModel extends AbstractTableModel{
    
    List <Reclamation> maListe;
    String [] entete ={"Nom","Prenom","Sujet"};
    

    public ReclamationModel() {
        
        ReclamationDAO pdao = new ReclamationDAO();
        maListe = new ArrayList<Reclamation>();
        maListe = pdao.afficherReclamation();
    }

   
    public int getRowCount() {
        return maListe.size();
    }

    
    public int getColumnCount() {
        return entete.length;
    }
    
    
    public String getColumnName(int i) {
        return entete[i];
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return maListe.get(rowIndex).getEmeteur().getNom();
            case 1:
                return maListe.get(rowIndex).getEmeteur().getPrenom();
            case 2:
                return maListe.get(rowIndex).getSujet();
            default : return null;
        }
    }
    
}
