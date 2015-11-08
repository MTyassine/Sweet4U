/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.sweet4u.DAO;

import edu.esprit.sweet4u.entites.ResponsablePatisserie;

/**
 *
 * @author Zeineb
 */
public interface IResponsablePatisserieDAO {
    
    
     public void insertResponsablePatisserie(ResponsablePatisserie rp);
      public void updateResponsablePatisserie(ResponsablePatisserie rp, int id) ;
      public void deleteResponsablePatisserie(ResponsablePatisserie rp);
      
    

    
}
