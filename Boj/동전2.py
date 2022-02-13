import sys
from itertools import combinations

input = sys.stdin.readline

n, k = map(int, input().split())

coins = []

for i in range(n):
    coins.append(int(input().rstrip()))
    
moneys = []

min_value = n+1

for i in range(1, n+1):
    temp = list(map(list, combinations(coins, i)))
    for j in temp:
        if sum(j) == k and min_value > len(j):
            print(len(j))
            break
else:
    print(-1)
