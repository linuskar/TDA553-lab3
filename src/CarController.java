import javax.swing.*;

import Vehicles.IVehicle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    
    // A list of cars, modify if needed
    //ArrayList<IVehicle> cars = new ArrayList<>();

    private CarModel carModel;
    private CarView frame;

    private JButton gasButton;
    private JButton brakeButton;
    private JButton turboOnButton;
    private JButton turboOffButton;
    private JButton liftBedButton;
    private JButton lowerBedButton;
    private JPanel controlPanelGrid;

    private JButton startButton;
    private JButton stopButton;

    private JPanel gasPanel;
    private JSpinner gasSpinner;
    private int gasAmount;
    private JLabel gasLabel;

    // Constructor
    public CarController(CarModel carModel, CarView carView){
        this.carModel = carModel;
        this.frame = carView;
        
        gasButton = new JButton("Gas");
        brakeButton = new JButton("Brake");
        turboOnButton = new JButton("Saab Turbo on");
        turboOffButton = new JButton("Saab Turbo off");
        liftBedButton = new JButton("Scania Lift Bed");
        lowerBedButton = new JButton("Lower Lift Bed");
        controlPanelGrid = new JPanel();
        
        startButton = new JButton("Start all cars");
        stopButton = new JButton("Stop all cars");

        gasPanel = new JPanel();
        gasSpinner = new JSpinner();  
        gasAmount = 0;
        gasLabel = new JLabel("Amount of gas");
    }


    //methods:
    public void makeButtonsGrid(){
        controlPanelGrid.setLayout(new GridLayout(2,4));
        controlPanelGrid.add(gasButton, 0);
        controlPanelGrid.add(turboOnButton, 1);
        controlPanelGrid.add(liftBedButton, 2);
        controlPanelGrid.add(brakeButton, 3);
        controlPanelGrid.add(turboOffButton, 4);
        controlPanelGrid.add(lowerBedButton, 5);
        controlPanelGrid.setPreferredSize(new Dimension((frame.getViewX()/2)+4, 200)); 
        controlPanelGrid.setBackground(Color.CYAN);
       
        frame.add(controlPanelGrid);
        //frame.setVisible(true);
    }
    public void makeGasInputSpinner(){
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        //gasPanel.setPreferredSize(new Dimension((frame.getX()/2), 200));
        frame.add(gasPanel);


        //frame.setVisible(true);
    }

    public void addButtonsAsActionListener(){
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
    }

    public void makeEngineButtons(){
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension((frame.getViewX()/5)-15,200));
        
        frame.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension((frame.getViewX()/5)-15,200));

        frame.add(stopButton);

        //frame.setVisible(true);
    }
    // public static void main(String[] args) {
    //     // Instance of this class
    //     CarController cc = new CarController();
        
    //     // Start a new view and send a reference of self
    //     cc.frame = new CarView("CarSim 1.0", cc);
        
    //     for (IVehicle car : cc.cars) {
    //         System.out.println(car.getEnginePower());
    //         cc.frame.drawPanel.putVehicle(car);
    //     }
    
    //     // Start the timer
    //     cc.timer.start();
    // }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle vehicle : carModel.getVehicles()) {
            vehicle.gas(gas);
        }
    }

 
}
