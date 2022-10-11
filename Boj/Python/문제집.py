#Baekjoon 1766
import sys, heapq
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n)]
degree = [0]*n

for _ in range(m):
    s, e = map(int, input().split())
    graph[s-1].append(e-1)
    degree[e-1] += 1
    
h = []

for i in range(n):
    if degree[i] == 0:
        heapq.heappush(h, i)
        
        
while h:
    now = heapq.heappop(h)
        
    print(now+1, end=" ")
        
    for k in graph[now]:
        degree[k] -= 1
        if degree[k] == 0:
            heapq.heappush(h, k)