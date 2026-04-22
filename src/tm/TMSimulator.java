import tm.Transition;
import tm.TuringMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TMSimulator {
    public static void main(String[] args) throws IOException {
        //gets filename from CL
        String filename = args[0];

        //open the file
        BufferedReader buffreader = new BufferedReader(new FileReader(filename));

        //read first two lines
        int numStates = Integer.parseInt(buffreader.readLine());
        int numSymbols = Integer.parseInt(buffreader.readLine());
        int alphabetSize = numSymbols + 1;

        //build the machine
        TuringMachine tm = new TuringMachine();
        tm.setHaltState(numStates - 1);

        //parse transitions
        for (int state = 0; state <= numStates - 2; state++){
            for (int symbol = 0; symbol < alphabetSize; symbol++){
                String line = buffreader.readLine();
                String[] parts = line.split(",");
                int nextState = Integer.parseInt(parts[0]);
                int writeSymbol = Integer.parseInt(parts[1]);
                char move = parts[2].charAt(0);
                tm.addTransition(state, symbol, new Transition(nextState, writeSymbol, move));
            }
        }



    }

}
