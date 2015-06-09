package fr.xebia.xke.solid.ocp;

import static fr.xebia.xke.solid.ocp.Orientation.OFFSET_ANGLE;

public enum Command {
    A {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x + currentPosition.orientation.offsetX,
                                currentPosition.y + currentPosition.orientation.offsetY,
                                currentPosition.orientation
                    );
        }
    },
    G {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(OFFSET_ANGLE));
        }
    },
    D {
        @Override
        public Position apply(Position currentPosition) {
            return new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(-OFFSET_ANGLE));
        }
    };

    public abstract Position apply(Position currentPosition);
}
