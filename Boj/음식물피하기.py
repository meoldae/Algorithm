import sys
import numpy as np
from collections import deque

N, M, K = map(int, input().split())

hallway = [['.' for i in range(M)] for j in range(N)]
visited = [[0 for i in range(M)] for j in range(N)]

# make hallway
for i in range(K):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    hallway[x-1][y-1] = '#'
        
queue = deque()
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

count = 0

for i in range(N):
    for j in range(M):
        if visited[i][j] == 1 or hallway[i][j] == '.':
            continue
        else:
            queue.append((i, j))
            cnt = 0
            
            while queue:
                x, y = queue.popleft()
                
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    
                    if nx >= N or nx < 0 or ny >= M or ny < 0:
                        continue
                    
                    elif visited[nx][ny] == 0 and hallway[nx][ny] == '#':
                        queue.append((nx, ny))
                        cnt += 1
                        visited[nx][ny] = 1
            count = max(count, cnt)

print(count)