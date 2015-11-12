
package edu.esprit.sweet4u.entites;

import java.util.Objects;

public class Patisserie {
    
    int id, id_rp, codePostal;
    double x, y;
    String delegation, adresse;

    public Patisserie(int id_rp, int codePostal, String delegation, String adresse) {
        this.id_rp = id_rp;
        this.codePostal = codePostal;
        this.delegation = delegation;
        this.adresse = adresse;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rp() {
        return id_rp;
    }

    public void setId_rp(int id_rp) {
        this.id_rp = id_rp;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Patisserie{" + "id=" + id + ", id_rp=" + id_rp + ", codePostal=" + codePostal + ", delegation=" + delegation + ", adresse=" + adresse + '}';
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
        final Patisserie other = (Patisserie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codePostal != other.codePostal) {
            return false;
        }
        if (!Objects.equals(this.delegation, other.delegation)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
