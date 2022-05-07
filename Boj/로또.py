#Baekjoon 6603
import sys
from itertools import combinations
input = sys.stdin.readline

lst = list(map(int, input().split()))

while lst[0] != 0:
    k = lst[0]
    nums = lst[1::]
    
    answer = list(combinations(nums, 6))
    for ans in answer:
        for i in ans:
            print(i, end=" ")
        print()
    print()
    lst = list(map(int, input().split()))