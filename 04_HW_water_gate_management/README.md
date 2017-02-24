# A - Water Gate Management

A dam has n water gates to let out water when necessary. Each water gate has its own capacity, water path and affected areas in the downstream. The affected areas may have a risk of flood when the water gate is open. The cost of potential damage caused by a water gate is measured in number calculated from the number of people and areas estimated to get affected. Suppose a water gate Gi has the volumetric flow rate of Fi m3/hour and the damage cost of Ci. In a certain situation, the dam has the volume V m3 of water to flush out within T hours. Your task is to manage the opening of the water gates in order to get rid of at least the specified volume of water within a limited time in condition that the damage cost is minimized.

For example, a dam has 4 water gates and their properties are shown in the following table.

Water Gate                 G1         G2         G3          G4
Flow rate (m3/hour)   720,000     50,000    130,000   1,200,000
Cost                  120,000     60,000     50,000     150,000

Case 1: You have to flush out the water 5 million m3 within 7 hours. The minimum cost will be 120,000 by letting the water gate G1 open for 7 hours.

Case 2: You have to flush out the water 5 million m3 within 30 hours. The minimum cost will be 110,000 by letting the water gates G2 and G3 open, for example, G2 is open for 29 hours and G3 is open for 28 hours.

Note that each water gate is independent and it can be open only in a unit of whole hour (no fraction of hour).

## Input

The first line includes an integer n indicating number of water gates (1 ≤ n ≤ 20). Then the next n lines contain, in each line, two integers: Fi and Ci corresponding to the flow rate (m3/hour) and the damage cost of the water gate Gi respectively. The next line contains the number m which is the number of test cases (1 ≤ m ≤ 50). The following m lines contain, in each line, two integers: V and T corresponding to the volume (m3) of water to let out within T hours. (1 ≤ Fi,V,Ci ≤ 109, 1≤T ≤1000)

## Output

For each test case, print out the minimum cost in the exact format shown in the sample output below. If it is not possible to let out the water of volume V in T hours from the dam, print out ‘IMPOSSIBLE’ (without quotation marks).

## Sample Input

```
4
720000 120000
50000 60000
130000 50000
1200000 150000
3
5000000 7
5000000 30
63000000 24
```

## Sample Output

```
Case 1: 120000
Case 2: 110000
Case 3: IMPOSSIBLE
```