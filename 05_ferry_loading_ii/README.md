# D - Ferry Loading II

Before bridges were common, ferries were used to transport cars across rivers. River ferries, un- like their larger cousins, run on a guide line and are powered by the river’s current. Cars drive onto the ferry from one end, the ferry crosses the river, and the cars exit from the other end of the ferry.
There is a ferry across the river that can take n cars across the river in t minutes and return in t minutes. m cars arrive at the ferry terminal by a given schedule. What is the earliest time that all the cars can be transported across the river? What is the minimum number of trips that the operator must make to deliver all cars by that time?

## Input

The first line of input contains c, the number of test cases. Each test case begins with n, t, m. m lines follow, each giving the arrival time for a car (in minutes since the beginning of the day). The operator can run the ferry whenever he or she wishes, but can take only the cars that have arrived up to that time.

## Output

For each test case, output a single line with two integers: the time, in minutes since the beginning of the day, when the last car is delivered to the other side of the river, and the minimum number of trips made by the ferry to carry the cars within that time.
You may assume that 0 < n, t, m < 1440. The arrival times for each test case are in non-decreasing order.

## Sample Input

```
2
2 10 10
0
10
20
30
40
50
60
70
80
90
2 10 3
10
30
40
```

## Sample Output

```
100 5
50 2
```