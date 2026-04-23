package tm;

/**
 * Represents a transition in a Turing machine. A transition consists of
 * the next state, the symbol to write, and the direction to move the head.
 */
public class Transition {

    private int nextState;
    private int writeSymbol;
    private char move;

    /**
     * Default constructor. Initializes the transition with the given
     * next state, write symbol, and move direction.
     * @param nextState
     * @param writeSymbol
     * @param move
     */
    public Transition(int nextState, int writeSymbol, char move) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.move = move;
    }

    /**
     * Getter for the next state of the transition.
     * @return nextState
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * Getter for the symbol to write in the transition.
     * @return writeSymbol
     */
    public int getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * Getter for the move direction of the transition.
     * @return move
     */
    public char getMove() {
        return move;
    }

    /**
     * Returns a string representation of the transition.
     * @return String
     */
    public String toString() {
        return "(" + nextState + ", " + writeSymbol + ", " + move + ")";
    }
}