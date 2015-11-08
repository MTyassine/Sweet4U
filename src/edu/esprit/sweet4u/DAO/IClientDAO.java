/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Client;

/**
 *
 * @author Zeineb
 */
public interface IClientDAO {
      public void insertClient(Client c);
      public void updateClient(Client c, int id) ;
      public void deleteClient(Client c);
      public int returnID2 (int id  );
      
    
}
