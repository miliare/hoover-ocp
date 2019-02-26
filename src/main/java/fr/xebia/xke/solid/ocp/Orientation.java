package fr.xebia.xke.solid.ocp;

public enum Orientation {
    NORTH(0, 1, 0),
    EAST(1, 0, 90),
    SOUTH(0, -1, 180),
    WEST(-1, 0, 270);

    final int x;
    final int y;
    private final int angle;

    Orientation(int X, int Y, int angle) {
        x = X;
        y = Y;
        this.angle = angle;
    }

    public Orientation turn(int angle) {
        int newAngle = Math.abs(this.angle + angle) % 360;
        return fromAngle(newAngle);
    }

    private Orientation fromAngle(int angle) {
        for (Orientation orientation : values()) {
            if (angle == orientation.angle) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid angle: " + angle);
    }

}
