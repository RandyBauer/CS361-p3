package tm;

import java.util.LinkedHashMap;
import java.util.Map;

public class TuringMachine {

    private Map<Integer, Map<Integer, Transition>> transitions;
    private Tape tape;
    private int currentState;
    private int haltState;

    public TuringMachine() {
        transitions = new LinkedHashMap<>();
        this.tape = new Tape();
        currentState = 0;
        haltState = 0;
    }
}