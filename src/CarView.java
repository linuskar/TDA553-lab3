import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Vehicles.IVehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements CarObserver{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarModel carModel;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    // JPanel controlPanel = new JPanel();

    // JPanel gasPanel = new JPanel();
    // JSpinner gasSpinner = new JSpinner();
    // int gasAmount = 0;
    // JLabel gasLabel = new JLabel("Amount of gas");

    // JButton gasButton = new JButton("Gas");
    // JButton brakeButton = new JButton("Brake");
    // JButton turboOnButton = new JButton("Saab Turbo on");
    // JButton turboOffButton = new JButton("Saab Turbo off");
    // JButton liftBedButton = new JButton("Scania Lift Bed");
    // JButton lowerBedButton = new JButton("Lower Lift Bed");

    // JButton startButton = new JButton("Start all cars");
    // JButton stopButton = new JButton("Stop all cars");

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
    // TODO: Take a good look and make sure you understand how these methods and components work
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
    
    // //temporär gas innan flyttning av buttons till CarController.
    // public void gas(int amount) {
    //     double gas = ((double) amount) / 100;
    //     for (IVehicle car : carModel.getVehicles()) {
    //         car.gas(gas);
    //     }
    // }
}