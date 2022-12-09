package Vehicles.Trucks;

import Vehicles.IVehicle;

public interface ITruck extends IVehicle{
    void raiseRampToMax();
    
    void lowerRampToMin();

    boolean getRampIsInDrivingPosition();

    //int getRampAngle();
}
