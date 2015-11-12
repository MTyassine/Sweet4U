/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.CommandeDAO2;
import edu.esprit.sweet4u.entites.Commande;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WiKi
 */
public class CommandesClientModel extends AbstractTableModel {

    
        List<Commande> maliste;

        String[] entete = {"Num° Commande", "Patisserie", "Approbation", "Paiement"};


    

    public CommandesClientModel() {
        CommandeDAO2 cdao = new CommandeDAO2();
        maliste = new ArrayList<Commande>();
        maliste = cdao.afficherCommandesClient();
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
        switch (columnIndex) {
 
            case 0:
                return maliste.get(rowIndex).getId();
            case 1:
                return maliste.get(rowIndex).getId_rp();
            case 2:
                return maliste.get(rowIndex).isStatutValidation();
            case 3:
                return maliste.get(rowIndex).isStatutPayement();

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        return entete[column];
    }
}
