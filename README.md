# Project 3: Turing Machine Simulator

* Author: Randy Bauer, Oliver Hill
* Class: CS361 Section 002
* Semester: Spring 2026

## Overview

This program simulates a Turing Machine in Java. It reads a machine description and optional input string from a file, builds the machine, and runs it on a bi-infinite tape.

State 0 is the start state, and the halting state is the state with the largest label. The tape uses 0 as the blank symbol and input symbols start at 1. The program then runs until the machine reaches the halting state and then it prints the contents of the tape.

## Compiling and Running

To compile locally:

`javac -d out src/tm/*.java`

To run:

`java -cp out tm.TMSimulator <file>`

On Onyx:

`javac tm/*.java`
`java tm.TMSimulator <file>`

## Results

The simulator produces the expected results for the provided test files.

Running file0.txt produces output 111111

Running file2.txt produces output with length 140 and symbol sum 414.

Running file5.txt produces output with length 20430 and symbol sum 47189.

## Code Interpretation, the "why"?

Transitions are stored using a nested map keyed by state and symbol. This keeps lookups simple and avoids extra classes.

The tape itself is implemented with a map from positions to symbols. This way the tape can grow in both directions and only stores the cells that are actually used.

The simulation follows the process of reading the current symbol, applying the transition, writing the new symbol, moving the head, and updating the state until the machine halts.