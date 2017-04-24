# Winning Streak

Mikael likes to gamble, and as you know, you can place bets on almost anything these days. A particular thing that has recently caught Mikael’s interest is the length of the longest winning streak of a team during a season (i.e. the highest number of consecutive games won). In order to be able to make smarter bets, Mikael has asked you to write a program to help him compute the expected value of the longest winning streak of his favourite teams.
In general, the probability that a team wins a game depends on a lot of different factors, such as whether they’re the home team, whether some key player is injured, and so on. For the first prototype of the program, however, we simplify this, and assume that all games have the same fixed probability p of being won, and that the result of a game does not affect the win probability for subsequent games.
The expected value of the longest streak is the average of the longest streak in all possible outcomes of all games in a season, weighted by their probability. For instance, assume that the season consists of only three games, and that p = 0.4. There are eight different outcomes, which we can represent by a string of ‘W’:s and ‘L’:s, indicating which games were won and which games were lost (for example, ‘WLW’ indicates that the team won the first and the third game, but lost the second). The possible results of the season are:

Result LLL LLW LWL LWW WLL WLW WWL WWW
Probability 0.216 0.144 0.144 0.096 0.144 0.096 0.096 0.064
Streak 0 1 1 2 1 1 2 3

In this case, the expected length of the longest winning streak becomes
0.216 · 0 + 0.144 · 1 + 0.144 · 1 + 0.096 · 2 + 0.144 · 1 + 0.096 · 1 + 0.096 · 2 + 0.064 · 3 = 1.104

## Input

Several test cases (at most 40), each containing an integer 1 ≤ n ≤ 500 giving the number of games in a season, and a floating point number 0 ≤ p ≤ 1, the win probability. Input is terminated by a case where n = 0, which should not be processed.

## Output

For each test case, give the expected length of the longest winning streak. The answer should be given as a floating point number with an absolute error of at most 10−4.

## Sample Input

```
3 0.4
10 0.75
0 0.5
```

## Sample Output

```
1.104000
5.068090
```