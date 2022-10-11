#Baekjoon 9375
import sys
from collections import defaultdict
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    clothes = defaultdict(list)
    for i in range(n):
        name, type = input().rstrip().split()
        clothes[type].append(name)
    
    answer = 1
    for key in clothes.keys():
        answer *= len(clothes[key])+1
    
    print(answer - 1)