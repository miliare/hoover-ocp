package fr.xebia.xke.solid.ocp;

import static fr.xebia.xke.solid.ocp.Command.of;

public class Hoover {

    private final String cleanProgram;
    private Position currentPosition = new Position();

    public Hoover(String cleanProgram) {
        this.cleanProgram = cleanProgram;
    }

    public void clean() {
        cleanProgram.chars()
                .mapToObj(stringCmd -> (char) stringCmd)
                .forEach(cmd -> currentPosition = of(cmd).compute(currentPosition));
    }

    public Position getPosition() {
        return currentPosition;
    }
}
