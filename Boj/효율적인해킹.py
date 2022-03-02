import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for i in range(n+1)]

for i in range(m):
    dst, src = map(int, input().split())
    graph[src].append(dst)

answer = defaultdict(list)
queue = deque()
def bfs(start):
    queue.append(start)
    visited[start] = 1
    cnt = 1
    while queue:
        x = queue.popleft()          
        for i in graph[x]:
            if visited[i] == 0:
                queue.append(i)
                cnt += 1
                visited[i] = 1
    answer[cnt].append(start) 
    
for i in range(1, n+1):    
    visited = [0 for i in range(n+1)]
    bfs(i)
    
last = sorted(answer[max(answer.keys())])
print(' '.join(map(str, last)))