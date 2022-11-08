#Baekjoon 14567
from collections import deque, defaultdict
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

degree = [0 for _ in range(n)]
semester = [0 for _ in range(n)]
graph = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    degree[b-1] += 1
    graph[a-1].append(b-1)
    
queue = deque()

for i in range(n):
    if degree[i] == 0:
        queue.append(i)
sem = 1    
while queue:
    for _ in range(len(queue)):
        subject = queue.popleft()
        if degree[subject] == 0:
            semester[subject] = sem
        for b in graph[subject]:
            degree[b] -= 1
            if degree[b] == 0:
                queue.append(b)
    sem += 1
    
print(*semester)