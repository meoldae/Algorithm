#Baekjoon 11652
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
answer = defaultdict(int)
for _ in range(n):
    answer[int(input())] += 1
    
print(sorted(list(answer.items()), key = lambda x:(-x[1], x[0]))[0][0])