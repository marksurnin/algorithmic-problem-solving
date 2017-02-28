# C - Number of Divisors Sequence

Consider an integer sequence N where, N0 = 1, Ni = Ni−1 + NOD(Ni−1) for i > 0

Here, NOD(x) = number of divisors of x.
So the first few terms of this sequence are 1 2 4 7 9 12 18 ...
Given two integers A and B, find out the number of integers in the above sequence that lies within the range [A, B].

## Input

The first line of input is an integer T (T < 100000), that indicates the number of test cases. Each case contains two integers, A followed by B (1 ≤ A ≤ B ≤ 1000000).

## Output

For each case, output the case number first followed by the required result.

## Sample Input

```
3
1 18
1 100
3000 4000
```

## Sample Output

```
Case 1: 7
Case 2: 20
Case 3: 87
```