package fr.xebia.xke.solid.ocp;

public class Forward implements Strategy {
    @Override
    public Position update(Position currentPosition) {
        return new Position(currentPosition.x + currentPosition.orientation.x, currentPosition.y + currentPosition.orientation.y, currentPosition.orientation);
    }
}
