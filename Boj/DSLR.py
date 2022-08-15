#Baekjoon 9019
import sys
from collections import deque
input = sys.stdin.readline
    
t = int(input())
for _ in range(t):
    src, dst = map(int, input().split())
    
    queue = deque()
    queue.append(["", src])
    visited = [False] * 10001
    visited[src] = True
    
    while queue:
        c, now = queue.popleft()
        
        if now == dst:
            print(c)
            break
        # D
        a_D = now*2 
        if a_D > 9999: a_D %= 10000
        if not visited[a_D]:
            queue.append([c+'D', a_D])
        
        # S
        a_S = now-1
        if a_S == -1: a_S = 9999
        if not visited[a_S]:
            queue.append([c+'S', a_S])
            
        # L
        a_L = (now%1000)*10 + now//1000
        if not visited[a_L]:
            queue.append([c+'L', a_L])
            
        # R
        a_R = (now%10)*1000 + now//10
        if not visited[a_R]:
            queue.append([c+'R', int(a_R)])