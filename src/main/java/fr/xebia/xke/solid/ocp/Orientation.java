package fr.xebia.xke.solid.ocp;

import static java.lang.Math.abs;

public enum Orientation {
    EAST(0, 1, 0),
    NORTH(90, 0, 1),
    WEST(180, -1, 0),
    SOUTH(270, 0, -1);

    public static final int OFFSET_ANGLE = 90;

    private final int angle;
    public final int offsetX;
    public final int offsetY;

    Orientation(int angle, int offsetX, int offsetY) {
        this.angle = angle;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public Orientation turn(int angle) {
        int newAngle = abs(this.angle + angle) % 360;
        return Orientation.fromAngle(newAngle);
    }

    private static Orientation fromAngle(int angle) {
        for (Orientation orientation : values()) {
            if (angle == orientation.angle) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid angle: " + angle);
    }
}
