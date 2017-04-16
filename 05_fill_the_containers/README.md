# B - Fill the Containers

A conveyor belt has a number of vessels of different capacities each filled to brim with milk. The milk
from conveyor belt is to be filled into ‘m’ containers. The constraints are:

- Whenever milk from a vessel is poured into a container, the milk in the vessel must be completely poured into that container only. That is milk from same vessel can not be poured into different containers.
- The milk from the vessel must be poured into the container in order which they appear in the conveyor belt. That is, you cannot randomly pick up a vessel from the conveyor belt and fill the container.
- The ith container must be filled with milk only from those vessels that appear earlier to those that fill jth container, for all i < j.

Given the number of containers ‘m’, you have to fill the containers with milk from all the vessels, without leaving any milk in the vessel. The containers need not necessarily have same capacity. You are given the liberty to assign any possible capacities to them. Your job is to find out the minimal possible capacity of the container which has maximal capacity. (If this sounds confusing, read down for more explanations.)

## Input

A single test case consist of 2 lines. The first line specifies 1 ≤ n ≤ 1000 the number of vessels in the conveyor belt and then ‘m’ which specifies the number of containers to which, you have to transfer the milk. (1 ≤ m ≤ 1000000). The next line contains, the capacity 1 ≤ c ≤ 1000000 of each vessel in order wich they appear in the conveyor belt. Note that, milk is filled to the brim of any vessel. So the capacity of the vessel is equal to the aumont of milk in it. There are several test cases terminated by EOF.

## Output

For each test case, print the minimal possible capacity of the container with maximal capacity. That is there exists a maximal capacity of the containers, below which you can not fill the containers without increasing the number of containers. You have to find such capacity and print it on a single line.

### Explanation of the output:

Here you are given 3 vessels at your disposal, for which you are free to assign the capacity. You can transfer, {1 2 3} to the first container, {4} to the second, {5} to third. Here the maximal capacity of the container is the first one which has a capacity of 6. Note that this is optimal too. That is, you can not have the maximal container, have a capacity, less than 6 and still use 3 containers only and fill the containers with all milk.

For the second one, the optimal way is, {4 78} into the first container, and {9} to the second container. So the minimal value of the maximal capacity is 82. Note that {4} to first container and {78 9} to the second is not optimal as, there exists a way to have an assignement of maximal capacity to 82, as opposed to 87 in this case.

## Sample Input

```
5 3
1 2 3 4 5
3 2
4 78 9
```

## Sample Output

```
6
82
```