/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.Personne;
import java.util.List;

/**
 *
 * @author Zeineb
 */
public interface IPersonneDAO {
    

     public void insertPersonne(Personne p);
      public void updatePersonne(Personne p, int id) ;
      public void deletePersonne(Personne p);
      public Personne FindPersonneByLogin(String login );
      public List<Personne> afficherPersonnes();
       public int  returnID (Personne p , String login );
    
    
    
    
}
