import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import Vehicles.IVehicle;
import Vehicles.Cars.Saab95;
import Vehicles.Cars.Volvo240;
import Vehicles.Trucks.Scania;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a singel cars position
    Map<IVehicle, BufferedImage> vehicles = new HashMap<IVehicle, BufferedImage>();

    void putVehicle(IVehicle vehicle) {
        if (vehicle instanceof Volvo240){
            vehicles.put(vehicle, volvoImage);
        } else if(vehicle instanceof Saab95) {
            vehicles.put(vehicle, saabImage);
        } else if(vehicle instanceof Scania) {
            vehicles.put(vehicle, scaniaImage);
        }
        
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IVehicle vehicle : vehicles.keySet()) {
            g.drawImage(vehicles.get(vehicle), (int) vehicle.getX(), (int) vehicle.getY(), null);
        }
    }
}
