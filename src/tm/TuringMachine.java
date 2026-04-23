package tm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a Turing machine. The Turing machine consists of a set of transitions,
 * a tape, a current state, and a halt state. The transitions are stored in a nested
 * HashMap, where the outer map maps states to inner maps, and the inner maps map 
 * symbols to transitions.
 * 
 * @author Randy Bauer, Oliver Hill
 */
public class TuringMachine {

    private Map<Integer, Map<Integer, Transition>> transitions;
    private Tape tape;
    private int currentState;
    private int haltState;

    /**
     * Default constructor. Initializes the Turing machine with an empty set of transitions,
     * an empty tape, and a current state of 0.
     */
    public TuringMachine() {
        transitions = new LinkedHashMap<>();
        this.tape = new Tape();
        currentState = 0;
        haltState = 0;
    }

    /**
     * Setter for the halt state of the Turing machine.
     * @param n
     */
    public void setHaltState(int n){
        haltState = n;
    }

    /**
     * Adds a transition to the Turing machine.
     * @param state
     * @param symbol
     * @param t
     */
    public void addTransition(int state, int symbol, Transition t){
        if (!transitions.containsKey(state)) {
            transitions.put(state, new HashMap<>());
        }
        transitions.get(state).put(symbol, t);
    }

    /**
     * Runs the Turing machine.
     */
    public void run(){
        while (currentState != haltState) {
            Transition tran = transitions.get(currentState).get(tape.read());
            tape.write(tran.getWriteSymbol());
            tape.moveHead(tran.getMove());
            currentState = tran.getNextState();
        }
        System.out.println(tape.getOutput());
    }

    /**
     * Loads the tape with the given input.
     * @param input
     */
    public void loadTape(String input){
        tape.loadInput(input);
    }
}
