package Vehicles;

public interface IVehicle extends Movable {
    void gas(double amount);

    void brake(double amount);

    double getEnginePower();

    double getCurrentSpeed();

}
