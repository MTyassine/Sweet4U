/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.sweet4u.GUI;

import edu.esprit.sweet4u.DAO.AdresseDAO;
import edu.esprit.sweet4u.entites.Patisserie;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOpenAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 *
 * @author Lenovo-G510
 */
public class OJMStest extends JPanel implements JMapViewerEventListener, WindowListener,ActionListener{
    
   

    private JMapViewer treeMap = null;

    private JLabel zoomLabel=null;
    private JLabel zoomValue=null;

    private JLabel mperpLabelName=null;
    private JLabel mperpLabelValue = null;

    double lon = 0.0;
    double lat = 0.0;
    JButton bouton ;
    
 
    //MapMarkerDot mapMarkerDot = new MapMarkerDot( lat, lon);
    /**
     * Constructs the {@code Demo}.
     */
    public OJMStest()  {

        
        treeMap = new JMapViewer();

        // Listen to the map viewer for user operations so components will
        // recieve events and update
        map().addJMVListener(this);


        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel helpPanel = new JPanel();
        
        bouton = new JButton("Marquer");
        bouton.addActionListener(this);

        mperpLabelName=new JLabel("Meters/Pixels: ");
        mperpLabelValue=new JLabel(String.format("%s",map().getMeterPerPixel()));

        zoomLabel=new JLabel("Zoom: ");
        zoomValue=new JLabel(String.format("%s", map().getZoom()));

        add(panel, BorderLayout.NORTH);
        add(helpPanel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout());
        panel.add(panelTop, BorderLayout.NORTH);
        JLabel helpLabel = new JLabel("Use right mouse button to move,\n "+"left double click or mouse wheel to zoom.");
        helpPanel.add(helpLabel);
        
        JComboBox tileSourceSelector = new JComboBox(new TileSource[] { new OsmTileSource.Mapnik(),
                new OsmTileSource.CycleMap(), new MapQuestOsmTileSource(), new MapQuestOpenAerialTileSource() });
        tileSourceSelector.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                map().setTileSource((TileSource) e.getItem());
            }
        });
        

        panelTop.add(tileSourceSelector);

        panelTop.add(zoomLabel);
        panelTop.add(zoomValue);
        panelTop.add(mperpLabelName);
        panelTop.add(mperpLabelValue);
        panelTop.add(bouton);

        add(treeMap, BorderLayout.CENTER);
        map().setZoom(6);
        map().setCenter(new Point(8605, 6427));
        

       


    }
    private JMapViewer map(){
        return treeMap;//.getViewer();
    }
    private static Coordinate c(double lat, double lon){
        return new Coordinate(lat, lon);
    }


    


    private void updateZoomParameters() {
        if (mperpLabelValue!=null)
            mperpLabelValue.setText(String.format("%s",map().getMeterPerPixel()));
        if (zoomValue!=null)
            zoomValue.setText(String.format("%s", map().getZoom()));
    }

    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            updateZoomParameters();
        }
    }
   
        /**
     * Exemple : JGoogleMapEditorPan dans un JFrame
     */
        public static void main(String [] args) throws SecurityException, IOException{
             
            
            final OJMStest map= new OJMStest();  
            SwingUtilities.invokeLater(new Runnable() {
           
               public void run() {
          
                  JFrame frame = new JFrame();
                    frame.add(map);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600, 520);
                    frame.setLocation(100, 100);
                    frame.setVisible(true);
                    
                    

            }
           });

}

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == bouton){
        
         map().addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                if (e.getButton() == MouseEvent.BUTTON1) {

                    lat = map().getPosition(e.getPoint()).getLat();
                    lon = map().getPosition(e.getPoint()).getLon();
                    System.out.println(map().getPosition(e.getPoint()));
                    System.out.println(lat+" , "+lon);
                    map().addMapMarker(new MapMarkerDot(lat, lon));
                    AdresseDAO adao = new AdresseDAO();
                    Patisserie p = new Patisserie(0, 0, null, null);
                    p.setX((int) lat);
                    p.setY((int) lon);
                    
                    adao.ajouterCoord(p);
                   
                    
                            

                }
            }
        });
        //this.setVisible(false);
        }
        
    }
    
        @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

