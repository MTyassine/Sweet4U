
package edu.esprit.sweet4u.test;

import edu.esprit.sweet4u.DAO.PersonneDAO;
import edu.esprit.sweet4u.entites.Commande;
import edu.esprit.sweet4u.entites.Personne;
import java.util.List;

public class Sweet4u {

    public static void main(String[] args) {
        PersonneDAO pdao = new PersonneDAO();
        List<Personne> listePersonnes = pdao.afficherPersonnes();
        System.out.println(listePersonnes);
    
        
        
    }
    
}
