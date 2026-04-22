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
        for (int state = 0; state <= numStates; state++){

        }



    }

}
