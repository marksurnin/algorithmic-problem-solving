# A - Gas Stations

G gas stations are authorized to operate over a road of length L. Each gas station is able to sell fuel over a specific area of influence, defined as the closed interval [x − r, x + r], where x is the station’s location on the road (0 ≤ x ≤ L) and r is its radius of coverage (0 < r ≤ L). The points covered by a gas station are those within its radius of coverage.

It is clear that the areas of influence may interfere, causing disputes among the corresponding gas stations. It seems to be better to close some stations, trying to minimize such interferences without reducing the service availability along the road.

The owners have agreed to close some gas stations in order to avoid as many disputes as possible. You have been hired to write a program to determine the maximum number of gas stations that may be closed, so that every point on the road is in the area of influence of some remaining station. By the way, if some point on the road is not covered by any gas station, you must acknowledge the situation and inform about it.

## Input

The input consists of several test cases. The first line of each test case contains two integer numbers L and G (separated by a blank), representing the length of the road and the number of gas stations, respectively (1 ≤ L ≤ 108, 1 ≤ G ≤ 104). Each one of the next G lines contains two integer numbers xi and ri (separated by a blank) where xi is the location and ri is the radius of coverage of the i-th gas station (0 ≤ xi ≤ L, 0 < ri ≤ L). The last test case is followed by a line containing two zeros.

## Output

For each test case, print a line with the maximum number of gas stations that can be eliminated, so that every point on the road belongs to the area of influence of some not closed station. If some point on the road is not covered by any of the initial G gas stations, print ‘-1’ as the answer for such a case.

## Sample Input

```
40 3
5 5
20 10
40 10
40 5
5 5
11 8
20 10
30 3
40 10
40 5
0 10
10 10
20 10
30 10
40 10
40 3
10 10
18 10
25 10
40 3
10 10
18 10
25 15
0 0
```

## Sample Output

```
0
2
3
-1
1
```