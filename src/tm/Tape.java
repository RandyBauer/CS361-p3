package tm;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the tape of a Turing machine. The tape is infinite in both directions
 * and is initialized with all 0's. The tape is implemented using a HashMap of Integer
 * positions to Integer symbols. The head starts at position 0.
 * 
 * @author Randy Bauer, Oliver Hill
 */
public class Tape {

    private Map<Integer, Integer> tape;
    private int head;
    private int minIndex;
    private int maxIndex;

    /**
     * Default constructor. Initializes the tape with all 0's.
     */
    public Tape() {
        this.tape = new HashMap<Integer, Integer>();
        this.head = 0;
        this.minIndex = 0;
        this.maxIndex = 0;
    }

    /**
     * Reads the symbol at the current head position. If the head is on a position
     * that has not been written to, it returns 0.
     * @return
     */
    public int read() {
        return tape.getOrDefault(head, 0);
    }

    /**
     * Writes the given symbol at the current head position.
     * @param symbol
     */
    public void write(int symbol){
        tape.put(head, symbol);
        if (head < minIndex) {
            minIndex = head;
        }
        if (head > maxIndex) {
            maxIndex = head;
        }
    }

    /**
     * Moves the head in the given direction. An 'R' moves the head to the right.
     * Otherwise, it moves the head to the left.
     * @param direction
     */
    public void moveHead(char direction){
        if (direction == 'R') {
            head++;
        }
        else {
            head--;
        }
        if (head < minIndex) {
            minIndex = head;
        }
        if (head > maxIndex) {
            maxIndex = head;
        }

    }

    /**
     * Loads the input string onto the tape, starting at position 0.
     * @param inputString
     */
    public void loadInput(String inputString){
        for (int i = 0; i < inputString.length(); i++) {
            tape.put(i, Character.getNumericValue(inputString.charAt(i)));
            if (i < minIndex) {
                minIndex = i;
            }
            if (i > maxIndex) {
                maxIndex = i;
            }
        }
    }

    /**
     * Returns the output string representing the symbols on the tape from the min index to the max index.
     * @return the output string
     */
    public String getOutput(){
        StringBuilder strb = new StringBuilder();
        for (int i = minIndex; i <= maxIndex; i++) {
            strb.append(tape.getOrDefault(i, 0));
        }
        return strb.toString();
    }
}
