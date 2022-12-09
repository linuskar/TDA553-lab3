import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vehicles.IVehicle;

public class CarModel {
    private Collection<IVehicle> vehicles;
    private Collection<CarObserver> observers;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener(this));
    
    public CarModel() {
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(CarObserver observer){
        observers.add(observer);
    }

    public void addVehicle(IVehicle vehicle){
        vehicles.add(vehicle);
    }

    public Collection<IVehicle> getVehicles() {
        return vehicles;
    }

    public void update(){
        for (IVehicle vehicle: vehicles){
            vehicle.move();
        }

        for (CarObserver o : observers) {
            o.updateObserver();
        }
    }

    public void start(){
        // time stuff
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        private CarModel carModel;

        public TimerListener(CarModel carModel) {
            this.carModel = carModel;
        }

        public void actionPerformed(ActionEvent e){
            carModel.update();
            //for (IVehicle vehicle : vehicles) {   
                

                //vehicle.move();
                // repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
            //}
        }
    }
}
