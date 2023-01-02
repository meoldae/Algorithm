#Baekjoon 15654
from itertools import permutations

n, m = map(int, input().split())
nums = list(map(int, input().split()))
answer = list(permutations(nums, m))
answer.sort()
for arr in answer:
    print(*arr)