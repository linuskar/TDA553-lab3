import Vehicles.IVehicle;
import Vehicles.Cars.Saab95;
import Vehicles.Cars.Volvo240;
import Vehicles.Trucks.Scania;
import java.awt.Color;


public class CarApp {
    public static void main(String[] args) {
        // Instance of model class
        CarModel model = new CarModel();
        // Instance of view
        CarView view = new CarView();
        // Instance of controller class
        CarController controller = new CarController(model);


        model.addVehicle(new Volvo240(500, Color.white, 0, 0));
        model.addVehicle(new Saab95(300, Color.red, 0, 100));
        model.addVehicle(new Scania(400, Color.black, 0, 200));
        
        for (IVehicle vehicle : model.getVehicles()) {
            cc.frame.drawPanel.putVehicle(vehicle);
        }
    
        // Start the timer
        model.start();
        //cc.timer.start();


    }
}
