import javax.swing.*;

import Vehicles.IVehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<IVehicle> cars = new ArrayList<>();

    private CarModel carModel;

    // Constructor
    public CarController(CarModel carModel){
        this.carModel = carModel;
    }


    //methods:

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
    //private class TimerListener implements ActionListener {
        
    //}

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.gas(gas);
        }
    }

 
}
