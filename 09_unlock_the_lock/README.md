# E - Unlock the Lock

Mr. Ferdaus has created a special type of 4-digit lock named “FeruLock” shown in the picture on the left. It always shows a 4-digit value and has a specific unlock code (An integer value). The lock is unlocked only when the unlock code is displayed. This unlock code can be made to appear quickly with the help of some of the special buttons available with that lock. Each button has a number associated with it. When any of these buttons is pressed, the number associated with that button is added with the displayed value and so a new number is displayed. The lock always uses least significant 4 digits after addition. After creating such a lock, he has found that, it is also very difficult for him to unlock the Ferulock. As a very good friend of Ferdaus, your task is to create a program that will help him to unlock the Ferulock by pressing these buttons minimum number of times.

## Input

There will be at most 100 test cases. For each test case, there will be 3 numbers: L, U and R where L (0000 ≤ L ≤ 9999) represents the current lock code, U (0000 ≤ U ≤ 9999) represents the unlock code and R (1 ≤ R ≤ 10) represents the number of available buttons. After that, there are R numbers (0 ≤ RVi ≤ 9999) in a line representing the value of buttons. The values of L, U, RVi will always be denoted by a four digit number (even if it is by padding with leading zeroes). Input will be terminated when L = U = R = 0.

## Output

For each test case, there will be one line of output which represents the serial of output followed by the minimum number of button press required to unlock the lock. If it is not possible to unlock the lock, then print a line ‘Permanently Locked’ instead (without quotes).

## Sample Input

```
0000 9999 1
1000
0000 9999 1
0001
5234 1212 3
1023 0101 0001
0 0 0
```

## Sample Output

```
Case 1: Permanently Locked
Case 2: 9999
Case 3: 48
```
