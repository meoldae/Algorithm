#Baekjoon 10974
import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())

nums = []
for i in range(1, n+1):
    nums.append(i)
    
answer = list(map(list, permutations(nums, n)))

for temp in answer:
    for num in temp:
        print(num, end=" ")
    print()