import javax.swing.*;

import Vehicles.IVehicle;

import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements CarObserver{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarModel carModel;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    // Constructor
    public CarView(String framename, CarModel carModel){
        this.carModel = carModel;
        initComponents(framename);
    }
    public int getViewX() {
        return X;
    }

    public int getViewY() {
        return Y;
    }
    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void updateObserver() {       
        for (IVehicle vehicle : carModel.getVehicles()) {
            drawPanel.putVehicle(vehicle);
        }

        repaint();
    }
}