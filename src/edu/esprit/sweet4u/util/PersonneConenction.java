
package edu.esprit.sweet4u.util;

import edu.esprit.sweet4u.entites.Personne;

public class PersonneConenction {
    
    static Personne p = null;
    
    private PersonneConenction(Personne p){
    
        PersonneConenction.p = new Personne();
        
        //PersonneConenction.setInstance(p);
        
    }
    
    public static Personne getInstance(){

           return p; 

    }
    
    public static void setInstance(Personne p){
        
        if(p==null){ // s'il n'y a pas d'instance , l crée une
            new PersonneConenction(p);
        }
        PersonneConenction.p = p ;
        
    }
    
}
