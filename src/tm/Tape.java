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

    public int read() {
//        return tape.get(head);
        return tape.getOrDefault(head, 0);
    }

    public void write(int symbol){
        tape.put(head, symbol);
        if (head < minIndex) {
            minIndex = head;
        }
        if (head > maxIndex) {
            maxIndex = head;
        }
    }

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

    public String getOutput(){
        StringBuilder strb = new StringBuilder();
        for (int i = minIndex; i <= maxIndex; i++) {
            strb.append(tape.getOrDefault(i, 0));
        }
        return strb.toString();
    }




}
