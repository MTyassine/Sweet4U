
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.ArticleDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;


import edu.esprit.sweet4u.entites.Article;






public class tablArticle  extends AbstractTableModel{
    
     
      List<Article> article ;
    String[]entetes = { "Nom"," Prix",  "Prix_Promo"};
    
     public tablArticle(){
         article = new ArticleDAO().afficherArticle();
        
    } 
   
    
      @Override
    public int getRowCount() {
        return article.size();
    }

    
      @Override
    public int getColumnCount() {
        return entetes.length;
    }

    
      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
                case 0:
                return article.get(rowIndex).getNom();
                case 1:
                return  article.get(rowIndex).getPrix();
                case 2:
                return  article.get(rowIndex).getPrixPromo();
                default:
                throw new IllegalArgumentException();
        }
    }
      @Override
                    public String getColumnName(int column){
            return entetes[column];
    }

    
    
    
    
    
}
