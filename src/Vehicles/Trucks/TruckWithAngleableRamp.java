package Vehicles.Trucks;


import Ramps.Ramp;
import Ramps.StandardTruckRamp;

import java.awt.Color;

public class TruckWithAngleableRamp extends Truck implements ITruckWithAngleableRamp {
   // private 

    public TruckWithAngleableRamp(String modelname, double enginePower, Color color, int nrDoors, double x, double y) {    
        //Ramp ramp = ;
        super(modelname, enginePower, color, nrDoors, x, y, 70, new StandardTruckRamp());

    }

    
    @Override
    public void lowerRamp(int degrees) {
        
        ramp.lowerRamp(degrees);
    }

    @Override
    public void raiseRamp(int degrees) {
        ramp.raiseRamp(degrees);
    }

    @Override
    public int getRampAngle() {
        return ramp.getMaxAngle();
    }
}
