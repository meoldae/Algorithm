#Baekjoon 13549
import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

visited = [-1] * 100001
visited[n] = 0

queue = deque()
queue.append(n)

while queue:
    now = queue.popleft()
    
    if now == k:
        print(visited[k])
        break
    
    if now - 1 >= 0 and visited[now-1] == -1:
        queue.append(now-1)
        visited[now-1] = visited[now] + 1
    
    if 0 <= now*2 < 100001 and visited[now*2] == -1:
        queue.appendleft(now*2)
        visited[now*2] = visited[now]
    
    if 0 <= now + 1 < 100001 and visited[now+1] == -1:
        queue.append(now+1)
        visited[now+1] = visited[now] + 1