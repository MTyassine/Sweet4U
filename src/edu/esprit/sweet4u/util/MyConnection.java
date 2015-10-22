/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.util;

import com.mysql.jdbc.MySQLConnection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo-G510
 */
public class MyConnection {
    String url="jdbc:mysql://localhost:3306/sweet4u";
    String login="root";
    String pwd="";
    static java.sql.Connection cnx =null;

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Connexion non etablie");
        }
    }
    
    public static java.sql.Connection getInstance(){
        if(cnx==null){ // s'il n'y a pas d'instance , l crée une
            new MyConnection();
        }
        return cnx;
    }

    
}
