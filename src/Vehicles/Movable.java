package Vehicles;

import Utility.IPositionable;

public interface Movable extends IPositionable {
    void move();

    void turnLeft();

    void turnRight();
}