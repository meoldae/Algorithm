#Baekjoon 11724
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, m = map(int, input().split())

graph = defaultdict(list)
visited = [0] * (n+1)
answer = set()

for _ in range(m):
    a, b = map(int, input().split())
    
    graph[a].append(b)
    graph[b].append(a)
    
count = 0
for i in range(1, n+1):    
    if visited[i] == 0:
        count += 1
        answer.add(count)
        queue = deque()
        queue.append(i)

        while queue:
            node = queue.popleft()
    
            for j in graph[node]:
                if visited[j] == 0:
                    queue.append(j)
                    visited[j] = 1
print(len(answer))