# B - Jill Rides Again

Jill likes to ride her bicycle, but since the pretty city of Greenhills where she lives has grown, Jill often uses the excellent public bus system for part of her journey. She has a folding bicycle which she carries with her when she uses the bus for the first part of her trip. When the bus reaches some pleasant part of the city, Jill gets off and rides her bicycle. She follows the bus route until she reaches her destination or she comes to a part of the city she does not like. In the latter event she will board the bus to finish her trip.
Through years of experience, Jill has rated each road on an integer scale of “niceness.” Positive niceness values indicate roads Jill likes; negative values are used for roads she does not like. There are not zero values. Jill plans where to leave the bus and start bicycling, as well as where to stop bicycling and re-join the bus, so that the sum of niceness values of the roads she bicycles on is maximized. This means that she will sometimes cycle along a road she does not like, provided that it joins up two other parts of her journey involving roads she likes enough to compensate. It may be that no part of the route is suitable for cycling so that Jill takes the bus for its entire route. Conversely, it may be that the whole route is so nice Jill will not use the bus at all.
Since there are many different bus routes, each with several stops at which Jill could leave or enter the bus, she feels that a computer program could help her identify the best part to cycle for each bus route.

## Input

The input file contains information on several bus routes. The first line of the file is a single integer b representing the number of route descriptions in the file. The identifier for each route (r) is the sequence number within the data file, 1 ≤ r ≤ b. Each route description begins with the number of stops on the route: an integer s, 2 ≤ s ≤ 20, 000 on a line by itself. The number of stops is followed by s − 1 lines, each line i (1 ≤ i < s) is an integer ni representing Jill’s assessment of the niceness of the road between the two stops i and i + 1.

## Output

For each route r in the input file, your program should identify the beginning bus stop i and the ending bus stop j that identify the segment of the route which yields the maximal sum of niceness, m = ni + ni+1 + . . . + nj−1 . If more than one segment is maximally nice, choose the one with the longest cycle ride (largest j − i). To break ties in longest maximal segments, choose the segment that begins with the earliest stop (lowest i). For each route r in the input file, print a line in the form:

```The nicest part of route r is between stops i and j```

However, if the maximal sum is not positive, your program should print:

```Route r has no nice parts```

## Sample Input

```
3
3
-1
6
10
4
-5
 4
-3
 4
 4
-4
 4
-5
4
-2
-3
-4
```

## Sample Output

```
The nicest part of route 1 is between stops 2 and 3
The nicest part of route 2 is between stops 3 and 9
Route 3 has no nice parts
```