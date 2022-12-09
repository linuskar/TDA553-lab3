package Ramps;

public interface IRamp {
    int getMaxAngle();

    int getMinAngle();

    int getRampAngle();

    void raiseRamp(int degrees);

    void lowerRamp(int degrees);

    void raiseRampToMax();

    void lowerRampToMin();

    boolean rampIsInDrivingPosition();
}
