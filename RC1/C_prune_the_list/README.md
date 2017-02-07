# C - Just Prune The List

You are given two list of integers. You can remove any number of elements from any of them. You have to ensure that after removing some elements both of the list will contain same elements, but not necessarily in same order. For example consider the following two lists:

```
1 2 3 2 1
1 2 5 2 3
```

After removing 1 from first list and 5 from second list, both lists will contain same elements. We will find the following lists after removing two elements.

```
1 2 3 2
1 2 2 3
```

What is the minimum number of elements to be removed to obtain two list having same elements?

## Input

The first line of the input file contains an integer T (T ≤ 100) which denotes the total number of test cases. The description of each test case is given below: First line will contain two integers N (1 ≤ N ≤ 10000), the number of element in the first list and M (1 ≤ M ≤ 10000), the number of element in the second list. The next line will contain N integers representing the first list followed by another line having M elements representing the second list. Each integer in the input is 32 bit signed integer.

## Output

For each test case output a single line containing the number of elements to be removed. See sample output for exact format.

## Sample Input

```
1
5 5
1 2 3 2 1
1 2 5 2 3
```

## Sample Output

```
2
```