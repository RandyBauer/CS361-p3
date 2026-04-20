package tm;

import java.util.HashMap;
import java.util.Map;

public class Tape {

    private Map<Integer, Integer> tape;
    private int head;
    private int minIndex;
    private int maxIndex;

    public Tape() {
        this.tape = new HashMap<Integer, Integer>();
        this.head = 0;
        this.minIndex = 0;
        this.maxIndex = 0;
    }


}