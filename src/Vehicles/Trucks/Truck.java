package Vehicles.Trucks;

import java.awt.Color;

import CustomExceptions.RampIsNotInCorrectPositionException;
import Ramps.IRamp;
import Vehicles.Vehicle;

public class Truck extends Vehicle implements ITruck, HasAngleableRamp {
    private IRamp ramp;

    Truck(String modelname, double enginePower, Color color, int nrDoors, double x, double y,IRamp ramp) {
        super(modelname, enginePower, color, nrDoors, x, y);
        this.ramp = ramp;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    protected boolean validGas() {
        return ramp.rampIsInDrivingPosition();
    }

    @Override
    public boolean getRampIsInDrivingPosition() {
        return ramp.rampIsInDrivingPosition();
    }

    @Override
    public void raiseRamp(int degrees) {
        ramp.raiseRamp(degrees);
    }

    @Override
    public void lowerRamp(int degrees) {
        ramp.raiseRamp(degrees);
    }

    /** Sets ramp to its highest position which is the maxAngle. */
    @Override
    public void raiseRampToMax() {
        if (getCurrentSpeed() == 0)
            ramp.raiseRampToMax();
    }

    /** Sets ramp to its lowest position which is 0. */ 
    @Override
    public void lowerRampToMin() {
        if (getCurrentSpeed() == 0)
            ramp.lowerRampToMin();
    }

    @Override
    public int getRampAngle() {
        return ramp.getRampAngle();
    }
}