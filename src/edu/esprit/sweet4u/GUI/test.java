/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lenovo-G510
 */
public class test {
    
    public test(){
    
        final OJMStest map= new OJMStest();  
        
        JFrame frame = new JFrame();
                    frame.add(map);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600, 520);
                    frame.setLocation(100, 100);
            
    }
}

 public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }
