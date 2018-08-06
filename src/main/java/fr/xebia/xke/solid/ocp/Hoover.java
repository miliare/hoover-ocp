package fr.xebia.xke.solid.ocp;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Hoover {

    public static final int TURN_RIGHT = 90;
    public static final int TURN_LEFT = -90;
    private final String program;
    private Position currentPosition = new Position();

    public Hoover(String program) {
        this.program = program;
    }

    public void clean() {
        for (int i = 0; i < program.length(); i++) {
            currentPosition = Strategy.of(program.charAt(i)).compute(currentPosition);
        }
    }


    public Position getPosition() {
        return currentPosition;
    }

    private enum Strategy {

        FORWARD('A', (currentPosition) -> new Position(currentPosition.x + currentPosition.orientation.plusX, currentPosition.y + currentPosition.orientation.plusY, currentPosition.orientation)),
        RIGHT('D', (currentPosition) -> new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(TURN_RIGHT))),
        LEFT('G', (currentPosition) -> new Position(currentPosition.x, currentPosition.y, currentPosition.orientation.turn(TURN_LEFT)));

        private final char direction;
        private final UnaryOperator<Position> move;

        Strategy(char direction, UnaryOperator<Position> move) {
            this.direction = direction;
            this.move = move;
        }

        public static Strategy of(char direction) {
            return Arrays
                    .stream(values())
                    .filter(strategy -> strategy.direction == direction)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid command: " + direction));
        }

        public Position compute(Position currentPosition) {
            return move.apply(currentPosition);
        }
    }
}
