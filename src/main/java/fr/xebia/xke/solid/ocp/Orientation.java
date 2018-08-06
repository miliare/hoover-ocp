package fr.xebia.xke.solid.ocp;

import java.util.Arrays;

import static java.lang.Math.abs;

public enum Orientation {
    NORTH(0, 0, 1),
    EAST(90, 1, 0),
    SOUTH(180, 0, -1),
    WEST(270, -1, 0);

    public int angle;
    public int plusX;
    public int plusY;

    Orientation(int angle, int plusX, int plusY) {
        this.angle = angle;
        this.plusX = plusX;
        this.plusY = plusY;
    }

    private static Orientation fromAngle(int newAngle) {
        return Arrays
                .stream(values())
                .filter(orientation -> orientation.angle == newAngle)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid angle: " + newAngle));
    }

    public Orientation turn(int angle) {
        int newAngle = abs(this.angle + angle) % 360;
        return Orientation.fromAngle(newAngle);
    }

}
