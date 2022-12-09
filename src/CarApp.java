import Vehicles.IVehicle;
import Vehicles.Cars.Saab95;
import Vehicles.Cars.Volvo240;
import Vehicles.Trucks.Scania;
import java.awt.Color;


public class CarApp {
    public static void main(String[] args) {
        // Instance of model class
        CarModel carModel = new CarModel();
        // Instance of the view which then gets added as an observer to the model
        CarView carView = new CarView("CarSim", carModel);
        carModel.addObserver(carView);
        // Instance of controller class
        CarController controller = new CarController(carModel, carView);
        controller.makeGasInputSpinner();
        controller.makeButtonsGrid();
        controller.makeEngineButtons();
        
        controller.addButtonsAsActionListener();
        carView.setVisible(true);
      
        
  
        carModel.addVehicle(new Volvo240(500, Color.white, 0, 0));
        carModel.addVehicle(new Saab95(300, Color.red, 0, 100));
        carModel.addVehicle(new Scania(400, Color.black, 0, 200));
    
    
        // Start the timer
        //carModel.update();
        carModel.start();

    }
}
