import sys
from collections import deque
input = sys.stdin.readline

n, m, v = map(int, input().split())
graph = [[0]*(n+1) for i in range(n+1)]
visited_dfs = [-1] * (n+1)
visited_bfs = [-1] * (n+1)

def dfs(v):
    visited_dfs[v] = 1
    print(v, end=" ")
    for i in range(1, n+1):
        if visited_dfs[i] == -1 and graph[v][i] == 1:
            dfs(i)
    

def bfs(v):
    visited_bfs[v] = 1
    queue = deque()
    queue.append(v)
    while queue:
        print(queue)
        temp = queue.popleft()
        print(temp, end=" ")
        for i in range(1, n+1):
            if visited_bfs[i] == -1 and graph[v][i] == 1:
                queue.append(i)
                visited_bfs[i] = 1
                
for i in range(m):
    start, end = map(int, input().split())
    graph[start][end] = graph[end][start] = 1

dfs(v)
print()
bfs(v)