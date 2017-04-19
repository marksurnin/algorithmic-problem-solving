# B – Tribbles

You have a population of k Tribbles. This particular species of Tribbles live for exactly one day and then die. Just before death, a single Tribble has the probability Pi of giving birth to i more Tribbles. What is the probability that after m generations, every Tribble will be dead?

## Input

The first line of input gives the number of cases, N. N test cases follow. Each one starts with a line containing n (1≤n≤1000), k (0≤k≤1000) and m (0≤m≤1000). The next n lines will give the probabilities P0, P1, . . . , Pn−1.

## Output
For each test case, output one line containing ‘Case #x:’ followed by the answer, correct up to an absolute or relative error of 10^(−6).

## Sample Input

```
4
3 1 1
0.33
0.34
0.33
3 1 2
0.33
0.34
0.33
3 1 2
0.5
0.0
0.5
4 2 2
0.5
0.0
0.0
0.5
```

## Sample Output

```
Case #1: 0.3300000
Case #2: 0.4781370
Case #3: 0.6250000
Case #4: 0.3164062
```