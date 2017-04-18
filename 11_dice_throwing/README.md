# D - Dice Throwing

*n* common cubic dice are thrown. What is the probability that the sum of all thrown dice is at least x?

## Input

The input file contains several test cases. Each test case consists two integers n (1 ≤ n ≤ 24) and x (0 ≤ x < 150). The meanings of n and x are given in the problem statement. Input is terminated by a case where n = 0 and x = 0. This case should not be processed.

## Output

For each line of input produce one line of output giving the requested probability as a proper fraction in lowest terms in the format shown in the sample output. All numbers appearing in output are representable in unsigned 64-bit integers. The last line of input contains two zeros and it should not be processed.

## Sample Input

```
3 9
1 7
24 24
15 76
24 56
24 143
23 81
7 38
0 0
```

## Sample Output

```
20/27
0
1
11703055/78364164096
789532654692658645/789730223053602816
25/4738381338321616896
1/2
55/46656
```