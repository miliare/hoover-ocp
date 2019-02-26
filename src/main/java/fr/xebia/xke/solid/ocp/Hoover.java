package fr.xebia.xke.solid.ocp;

public class Hoover {

    private final String program;
    private Position currentPosition = new Position();

    public Hoover(String program) {
        this.program = program;
    }

    public void clean() {
        for (int i = 0; i < program.length(); i++) {
            switch (program.charAt(i)) {
                case ('A'):
                    currentPosition = new Position(currentPosition.x + currentPosition.orientation.x, currentPosition.y + currentPosition.orientation.y, currentPosition.orientation);
                    break;
                case ('D'):
                    currentPosition = new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(90));
                    break;
                case ('G'):
                    currentPosition = new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(-90));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + program.charAt(i));
            }
        }
    }

    public Position getPosition() {
        return currentPosition;
    }
}
