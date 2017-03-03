# Jaccard

Time limit: 3 seconds

The Jaccard Similarity between two sets A and B is defined as Jaccard(A, B) = |A ∩ B|/|A ∪ B|, where |S| is the size of a set S. Please note that a set does not contain any duplicates.

Jaccard Similarity can be applied in data mining to measure the similarity of two word lists. Given two word lists LA, LB, we let A be the set of words that appear in LA, and B be the set of words that appear in LB. Then Jaccard(LA, LB) = Jaccard(A, B).

In this problem, your task is to compute Jaccard(LA, LB) given LA, LB.

## Input

The first line of the input contains the number of test cases, T.
Each test case has two integers N, M on the first line, giving the number of words in LA and LB. The first line contains space-separated words of LA. The second line contains space-separated words of LB.

## Output

For each case output one line for Jaccard(LA, LB). Your answer will be considered correct, if it is within an absolute or relative error of 10^(−6) compared with the correct answer.

## Constraints

- 1 ≤ T ≤ 10
- 1 ≤ N, M ≤ 105
- Words in each list are distinct.
- Words contain only lowercase English letters.
- Length of any word ≤ 10

## Sample Input

```
4
4 5
a b c d
a c e f g
3 3
aaa ppp sss
aps psa sap
6 11
the first word list is short
the second word list is very veery veeery veeeery veeeeery looooooong
3 3
exactly the same
exactly the same
```

## Sample Output

```
0.285714
0.000000
0.307692
1.000000
```