package fr.xebia.xke.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class Hoover {

    private final String program;
    private Map<Character, Strategy> stategies = new HashMap<Character, Strategy>() {{
        put('A', new Forward());
        put('D', new Right());
        put('G', new Left());
    }};

    private Position currentPosition = new Position();

    public Hoover(String program) {
        this.program = program;
    }

    public void clean() {
        for (int i = 0; i < program.length(); i++) {
            currentPosition = stategies.get(program.charAt(i)).update(currentPosition);
        }
    }

    public Position getPosition() {
        return currentPosition;
    }
}
