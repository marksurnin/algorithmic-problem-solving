# Angry Programmer

You, a programmer of an important software house, have been fired because you didn’t solve an impor- tant problem that was assigned to you. You are very furious and want to take revenge on your boss, breaking the communication between his computer and the central server.
The computer of your boss and the central server are in the same network, which is composed of many machines (computers) and wires linking pairs of those machines. There is at most one wire between any pair of machines and there can be pairs of machines without a wire between them.
To accomplish your objective, you can destroy machines and wires, but you can’t destroy neither the computer of your boss nor the central server, because those machines are monitored by security cameras. You have estimated the cost of blowing up each machine and the cost of cutting each wire in the network.
You want to determine the minimum cost of interrupting the communication between your boss’ computer and the central server. Two computers A and B can communicate if there is a sequence of undestroyed machines x1 , . . . , xn such that x1 = A, xn = B and xi is linked with xi+1 with an uncut wire (for each 1 ≤ i ≤ n − 1).

## Input

The input consists of several test cases. Each test case is represented as follows:
- A line with two integers M and W (2 ≤ M ≤ 50, 0 ≤ W ≤ 1000), representing (respectively) the number of machines and the number of wires in the network.
- M − 2 lines, one per machine (different from the boss’ machine and the central server), containing the following information separated by spaces:
– An integer i (2 ≤ i ≤ M − 1) with the identifier of the machine. Assume that the boss’ machine has id 1 and that the central server has id M.
– An integer c (0 ≤ c ≤ 100000) specifying the cost of destroying the machine. • W lines, one per wire, containing the following information separated by spaces:
– Two integers j and k (1 ≤ j < k ≤ M) specifying the identifiers of the machines linked by the wire. Remember that the wire is bidirectional.
– An integer d (0 ≤ d ≤ 100000) specifying the cost of cutting the wire. The end of the input is specified by a line with the string ‘0 0’.
Suppose that the machines have distinct identifiers.

## Output

For each test case, print a line with the minimum cost of interrupting the communication between the computer of your boss and the central server.

## Sample Input

```
4 4
3 5
2 2
1 2 3
1 3 3
2 4 1
3 4 3
4 4
3 2
2 2
1 2 3
1 3 3
2 4 1
3 4 3
0 0
```

## Sample Output

```
4
3
```