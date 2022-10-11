#Baekjoon 
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[0]*n for _ in range(n)]
answer = set()
for _ in range(m):
    src, dst = map(int, input().split())
    
    graph[src-1][dst-1] = 1
    graph[dst-1][src-1] = 1
    
for idx in range(n):
    if graph[0][idx] == 1:
        answer.add(idx)
        
        for ff in range(n):
            if graph[idx][ff] == 1:
                answer.add(ff)

if 0 in answer:
    answer.remove(0)

print(len(answer))