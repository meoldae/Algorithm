#Baekjoon 22868
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = defaultdict(list)
    
for _ in range(m):
    a, b = map(int, input().split())
        
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n+1):
    graph[i].sort()
    
s, e = map(int, input().split())
visited = [0]*(n+1)
global_load = []

def bfs(start, goal):        
    global global_load
    queue = deque()
    queue.append([start, 0, []])
    
    visited[start] = 1
    
    while queue:
        node, count, load = queue.popleft()
        count += 1

        for i in graph[node]:
            temp_load = load[::]
            if i == goal:
                global_load = temp_load[::]
                return count                
            else:
                if visited[i] == 0:
                    visited[i] = 1
                    temp_load.append(i)
                    queue.append([i, count, temp_load])
    return

val = bfs(s, e)

visited = [0]*(n+1)
for i in global_load:
    visited[i] = 1

val += bfs(e, s)
print(val)