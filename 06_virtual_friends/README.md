# B - Virtual Friends

These days, you can do all sorts of things online. For example, you can use various websites to make virtual friends. For some people, growing their social network (their friends, their friends’ friends, their friends’ friends’ friends, and so on), has become an addictive hobby. Just as some people collect stamps, other people collect virtual friends.
Your task is to observe the interactions on such a website and keep track of the size of each person’s network.
Assume that every friendship is mutual. If Fred is Barney’s friend, then Barney is also Fred’s friend.

## Input

The first line of input contains one integer specifying the number of test cases to follow. Each test case begins with a line containing an integer F, the number of friendships formed, which is no more than 100 000. Each of the following F lines contains the names of two people who have just become friends, separated by a space. A name is a string of 1 to 20 letters (uppercase or lowercase).

## Output

Whenever a friendship is formed, print a line containing one integer, the number of people in the social network of the two people who have just become friends.

## Sample Input

```
1
3
Fred Barney
Barney Betty
Betty Wilma
```

## Sample Output

```
2
3
4
```
