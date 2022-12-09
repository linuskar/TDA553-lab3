package Vehicles.Trucks;

import java.awt.Color;

import Ramps.StandardTruckRamp;

public class Scania implements ITruck, HasAngleableRamp {
    private Truck truck;
    //private int maxAngle;

    public Scania(double enginePower, Color color, double x, double y) {
        //this.maxAngle = 70;
        this.truck = new Truck("Scania", enginePower, color, 2, x, y, new StandardTruckRamp());
    }

    // --------- delegated methods -----------------
    @Override
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }
    
    @Override
    public void brake(double amount) {
        truck.brake(amount);
    }

    @Override
    public double getEnginePower() {
        return truck.getEnginePower();
    }

    @Override
    public double getX() {
        return truck.getX();
    }

    @Override
    public double getY() {
        return truck.getY();
    }

    @Override
    public void move() {
        truck.move();
        
    }

    @Override
    public void turnLeft() {
        truck.turnLeft();
    }

    @Override
    public void turnRight() {
        truck.turnRight();
    }

    /**
     * Method for increasing speed for a Scania Truck.
     * 
     * @param amount
     */
     @Override
    public void gas(double amount) {
        truck.gas(amount);

    }

    // -------- Methods with own implementation ------------

    // raises ramp according to degrees only if current speed is zero.
    public void raiseRamp(int degrees) {
        if (getCurrentSpeed() == 0) {
            truck.raiseRamp(degrees);
        }
    }

    public void lowerRamp(int degrees) {
        truck.lowerRamp(degrees);
    }

    @Override
    public void raiseRampToMax() {
        if (getCurrentSpeed() == 0) {
            truck.raiseRampToMax();
        }
    }

    @Override
    // when no argument is thrown sets
    public void lowerRampToMin() {
        truck.lowerRampToMin();
    }

    @Override
    public boolean getRampIsInDrivingPosition() {
        return truck.getRampIsInDrivingPosition();
    }

    @Override
    public int getRampAngle() {
        // TODO Auto-generated method stub
        return truck.getRampAngle();
    }
}
