package Utility;

import Vehicles.Cars.ICar;

public interface ICarStorage{
    int getMaxCapacity();
    void loadCar(ICar carToBeLoaded, Positionable currentPositionableObject);
    void unLoadCar(ICar carToBeUnloaded, Positionable currentPositionableObject);
}
