import javax.swing.*;

import Vehicles.IVehicle;
import Vehicles.Cars.Saab95;
import Vehicles.Cars.Volvo240;
import Vehicles.Trucks.Scania;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<IVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        

        cc.cars.add(new Volvo240(500, Color.white, 0, 0));
        cc.cars.add(new Saab95(300, Color.red, 0, 100));
        cc.cars.add(new Scania(400, Color.black, 0, 200));


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        
        for (IVehicle car : cc.cars) {
            System.out.println(car.getEnginePower());
            cc.frame.drawPanel.putVehicle(car);
        }
    
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle car : cars) {          
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.gas(gas);
        }
    }
}
