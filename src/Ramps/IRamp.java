package Ramps;

public interface IRamp {
    int getMaxAngle();

    int getMinAngle();

    int getRampAngle();
    

    // raise ramp from current position, can only between [0-70].

    void raiseRamp(int degrees);

    // lower ramp from current position, can only between [0-70].
    void lowerRamp(int degrees);

    void raiseRampToMax();

    void lowerRampToMin();

    boolean rampIsInDrivingPosition();
}
