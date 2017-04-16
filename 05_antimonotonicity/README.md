# E - Antimonotonicity

I have a sequence Fred of length n com- prised of integers between 1 and n inclu- sive. The elements of Fred are pairwise distinct. I want to find a subsequence Mary of Fred that is as long as possible and has the property that:

Mary[0] > Mary[1] < Mary[2] > Mary[3] < ...

## Input

The first line of input will contain a single integer T expressed in decimal with no leading zeroes. T will be at most 50. T test cases will follow.

Each test case is contained on a single line. A line describing a test case is formatted as follows:

n Fred[0] Fred[1] Fred[2] ... Fred[n − 1].

where n and each element of Fred is an integer expressed in decimal with no leading zeroes. No line will have leading or trailing whitespace, and two adjacent integers on the same line will be separated by a single space. n will be at most 30000.

## Output

For each test case, output a single integer followed by a newline — the length of the longest subsequence Mary of Fred with the desired properties.

## Sample Input

```
4
512345
554321
551423
524135
```

## Sample Output

```
1
2
5
3
```