package tm;

import java.util.HashMap;
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

    public void setHaltState(int n){
        haltState = n;
    }

    public void addTransition(int state, int symbol, Transition t){
        if (!transitions.containsKey(state)) {
            transitions.put(state, new HashMap<>());
        }
        transitions.get(state).put(symbol, t);
    }

    public void run(){
        while (currentState != haltState) {
            Transition tran = transitions.get(currentState).get(tape.read());
            tape.write(tran.getWriteSymbol());
            tape.moveHead(tran.getMove());
            currentState = tran.getNextState();
        }
        System.out.println(tape.getOutput());
    }

    public void loadTape(String input){
        tape.loadInput(input);
    }
}
