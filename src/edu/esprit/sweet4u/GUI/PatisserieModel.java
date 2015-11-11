
package edu.esprit.sweet4u.GUI;



import edu.esprit.sweet4u.DAO.AdresseDAO;
import edu.esprit.sweet4u.DAO.ResponsablePatisserieDAO;
import edu.esprit.sweet4u.entites.Patisserie;
import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.entites.ResponsablePatisserie;
import edu.esprit.sweet4u.util.PersonneConenction;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PatisserieModel extends AbstractTableModel{
    
    List <Patisserie> maListe;
    String [] entete ={"Delegation","Adresse","Code Postal"};
    

    public PatisserieModel() {
        
        Personne  pc = PersonneConenction.getInstance();
        
        ResponsablePatisserie rp = new ResponsablePatisserie();
        ResponsablePatisserieDAO rpdao = new ResponsablePatisserieDAO();
        
        rp = rpdao.RechercherResponsable(pc.getId());
        
        int id_rp = rp.getId();
        
        AdresseDAO pdao = new AdresseDAO();
        maListe = new ArrayList<Patisserie>();
        maListe = pdao.afficherPatisserie(id_rp);
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
                return maListe.get(rowIndex).getDelegation();
            case 1:
                return maListe.get(rowIndex).getAdresse();
            case 2:
                return maListe.get(rowIndex).getCodePostal();
            default : return null;
        }
    }
}
