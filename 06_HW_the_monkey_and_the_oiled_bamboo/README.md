# C - The Monkey and The Oiled Bamboo

It’s time to remember the disastrous moment of the old school math. Yes, the little math problem with the monkey climbing on an oiled bamboo. It goes like:

“A monkey is trying to reach the top of an oiled bamboo. When he climbs up 3 feet, he slips down 2 feet. Climbing up 3 feet takes 3 seconds. Slipping down 2 feet takes 1 second. If the pole is 12 feet tall, how much time does the monkey need to reach the top?”

When I was given the problem, I took it seriously. But after a while I was thinking of killing the mon- key instead of doing the horrible math! I had rather different plans (!) for the man who oiled the bamboo.
Now we, the problem-setters, got a similar oiled bamboo. So, we thought we could do better than the traditional monkey. So, I tried first. I jumped and climbed up 3.5 feet (better than the monkey! Huh!) But in the very next second I just slipped and fell off to the ground. I couldn’t remember anything after that, when I woke up, I found myself in a bed and the anx- ious faces of the problem setters around me. So, like old school times, the monkey won with the oiled bamboo.
So, I made another plan (somehow I want to beat the monkey), I took a ladder instead of the bamboo. Initially I am on the ground. In each jump I can jump from the current rung (or the ground) to the next rung only (can’t skip rungs). Initially I set my strength factor k. The meaning of k is, in any jump I can’t jump more than k feet. And if I jump exactly k feet in a jump, k is decremented by 1. But if I jump less than k feet, k remains same.

For example, let the height of the rungs from the ground are 1, 6, 7, 11, 13 respectively and k be 5. Now the steps are:

1. Jumped 1 foot from the ground to the 1st rung (ground to 1). Since I jumped less than k feet, k remains 5.
2. Jumped 5 feet for the next rung (1 to 6). So, k becomes 4.
3. Jumped 1 foot for the 3rd rung (6 to 7). So, k remains 4.
4. Jumped 4 feet for the 4th rung (7 to 11). This k becomes 3.
5. Jumped 2 feet for the 5th rung (11 to 13). And so, k remains 3.

Now you are given the heights of the rungs of the ladder from the ground, you have to find the minimum strength factor k, such that I can reach the top rung.

## Input

Input starts with an integer T (≤ 500), denoting the number of test cases.
Each case starts with a line containing an integer n denoting the number of rungs in the ladder. The next line contains n space separated integers, r1,r2,...,rn (1 ≤ r1 < r2 < ... < rn ≤ 107) denoting the heights of the rungs from the ground.
For all cases, 1 ≤ n ≤ 10, except 5 cases where 10 < n ≤ 105.

## Output

For each case, print the case number and the minimum value of k as described above.

## Sample Input

```
2
5
1 6 7 11 13
4
3 9 10 14
```

## Sample Output

```
Case 1: 5
Case 2: 6
```