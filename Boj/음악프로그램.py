#Baekjoon 2623
import sys
from collections import defaultdict
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
singers = [0]*(n+1)
graph = defaultdict(list)
queue = deque()

for _ in range(m):
    temp = list(map(int, input().split()))
    
    for i in range(1, len(temp)-1):
        graph[temp[i]].append(temp[i+1])
        singers[temp[i+1]] += 1

for i in range(1, len(singers)):
    if singers[i] == 0:
        queue.append(i)

answer = []    
while queue:
    now = queue.popleft()
    answer.append(now)
    
    for next in graph[now]:
        singers[next] -= 1
        
        if singers[next] == 0:
            queue.append(next)

if len(answer) == n:
    for node in answer:
        print(node)
else:
    print(0)