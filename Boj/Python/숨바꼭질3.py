#Baekjoon 13549
import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

def bfs(n, k):
    queue = deque()
    queue.append((n, 0))
    visited = [0]*(400001)
    while queue:
        now, count = queue.popleft()
            
        visited[now] = count

        plus = now+1
        mul = now*2
        minus = now-1
            
        if k in [plus, minus]:
            return count + 1
        elif k == mul:
            return count
        
        if visited[plus] == 0 or visited[plus] > count+1:
            visited[plus] = count+1
            queue.append((plus, count+1))
        
        if visited[mul] == 0 or visited[mul] > count:
            visited[mul] = count
            queue.append((mul, count))
        
        if (visited[minus] == 0 or visited[minus] > count+1) and minus >= 0:
            visited[minus] = count+1
            queue.append((minus, count+1))

print(bfs(n, k))