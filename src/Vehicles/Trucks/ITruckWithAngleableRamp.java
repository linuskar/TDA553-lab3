package Vehicles.Trucks;

public interface ITruckWithAngleableRamp extends ITruck{
    void lowerRamp(int degrees);

    void raiseRamp(int degrees);

    int getRampAngle();
}
