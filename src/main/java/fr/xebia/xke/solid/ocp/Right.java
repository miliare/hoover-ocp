package fr.xebia.xke.solid.ocp;

public class Right implements Strategy {
    @Override
    public Position update(Position currentPosition) {
        return new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(90));
    }
}
