package fr.xebia.xke.solid.ocp;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.UnaryOperator;

import static fr.xebia.xke.solid.ocp.Orientation.OFFSET_ANGLE;


public enum Command {

    FORWARD('A', currentPosition -> {
        return new Position(currentPosition.x + currentPosition.orientation.offsetX,
                currentPosition.y + currentPosition.orientation.offsetY,
                currentPosition.orientation);
    }),
    LEFT('G', currentPosition -> {
        return new Position(currentPosition.x, currentPosition.y,
                currentPosition.orientation.turn(OFFSET_ANGLE));
    }),
    RIGHT('D', currentPosition -> {
        return new Position(currentPosition.x, currentPosition.y,
                currentPosition.orientation.turn(-OFFSET_ANGLE));
    });

    private final char symbol;
    private UnaryOperator<Position> operator;

    Command(char symbol, UnaryOperator<Position> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Command of(Character operationElement) {
        Optional<Command> operator = findCommandBySymbol(operationElement);
        return operator.orElse(null);
    }

    private static Optional<Command> findCommandBySymbol(Character operationElement) {
        return Arrays.stream(values()).filter(op -> op.symbol == operationElement).findAny();
    }

    public Position compute(Position currentPosition) {
        return operator.apply(currentPosition);
    }
}
