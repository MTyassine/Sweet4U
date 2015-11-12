
package edu.esprit.sweet4u.entites;

import java.util.Date;

public class Commentaire {
    
    private int id;
    private int id_p;
    private int id_a;
    private String datecom;
    private String commentaire;
    private int signalement;
    private boolean visible;

    /**
     *
     * @param id
     * @param id_p
     * @param id_a
     * @param commentaire
     * 
     */
    public Commentaire(int id,int id_p,int id_a, String commentaire) {
        this.id_p = id_p;
        this.id=id;
        this.id_a = id_a;
  
        this.commentaire = commentaire;
        
    }

    public Commentaire() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSignalement() {
        return signalement;
    }

    public void setSignalement(int signalement) {
        this.signalement = signalement;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    

    public String getDatecom() {
        return datecom;
    }

    public void setDatecom(String datecom) {
        this.datecom = datecom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", id_p=" + id_p + ", id_a=" + id_a + ", date=" + datecom + ", commentaire=" + commentaire + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
