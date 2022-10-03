#Baekjoo n 2252
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
degree = [0]*n
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    degree[b] += 1
    graph[a].append(b)

queue = deque()

for i in range(n):
    if degree[i] == 0:
        queue.append(i)

while queue:
    now = queue.popleft()
    print(now+1, end=" ")
    
    for next in graph[now]:
        degree[next] -= 1
        if degree[next] <= 0:
            queue.append(next)    