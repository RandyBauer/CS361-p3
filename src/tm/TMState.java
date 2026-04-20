package tm;

import java.util.LinkedHashMap;

public class TMState {

    private int id;
    private LinkedHashMap<TMState, LinkedHashMap<?, ?>> transitions;

    public TMState(String name) {
        this.id = id;
        transitions = new LinkedHashMap<TMState, LinkedHashMap<?, ?>>();
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "" + id;
    }
}