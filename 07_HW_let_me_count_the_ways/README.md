# A - Let Me Count The Ways

After making a purchase at a large department store, Mel’s change was 17 cents. He received 1 dime, 1 nickel, and 2 pennies. Later that day, he was shopping at a convenience store. Again his change was 17 cents. This time he received 2 nickels and 7 pennies. He began to wonder ’ ”How many stores can I shop in and receive 17 cents change in a different configuration of coins? After a suitable mental struggle, he decided the answer was 6. He then challenged you to consider the general problem.

Write a program which will determine the number of different combinations of US coins (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c) which may be used to produce a given amount of money.

## Input

The input will consist of a set of numbers between 0 and 30000 inclusive, one per line in the input file.

## Output

The output will consist of the appropriate statement from the selection below on a single line in the output file for each input value. The number m is the number your program computes, n is the input value.

```
There are m ways to produce n cents change.
There is only 1 way to produce n cents change.
```

## Sample input

```
17
11
4
```

## Sample output

```
There are 6 ways to produce 17 cents change.
There are 4 ways to produce 11 cents change.
There is only 1 way to produce 4 cents change.
```