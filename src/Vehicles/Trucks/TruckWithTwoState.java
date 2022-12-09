package Vehicles.Trucks;

import Ramps.Ramp;
import Ramps.TransporterRamp;
import java.awt.Color;


public class TruckWithTwoState extends Truck {
    public TruckWithTwoState(String modelname, double enginePower, Color color, int nrDoors, double x, double y) {
        super(modelname, enginePower, color, nrDoors, x, y, 0, new TransporterRamp());
    }
}
