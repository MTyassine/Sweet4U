/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.entites.Personne;
import edu.esprit.sweet4u.DAO.PersonneDAO;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo-G510
 */
public class PersonneModel extends AbstractTableModel  {
    List<Personne> maliste;
    String[] entete={"Nom","Prenom","Adresse","CIN","login"};

    public PersonneModel() {
        PersonneDAO pdao = new PersonneDAO();
        maliste = new ArrayList<Personne>();
        maliste = pdao.afficherPersonnes();
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
              return maliste.get(rowIndex).getNom();
          case 1:
              return maliste.get(rowIndex).getPrenom();
          case 2:
              return maliste.get(rowIndex).getAdresse();
          case 3 : 
          return maliste.get(rowIndex).getCin();
          case 4:
          return maliste.get(rowIndex).getLogin();
          
              
              
          default:return null;   
      }  
    }
    
    public String getColumnName(int column){
        return entete[column];
    }

}
