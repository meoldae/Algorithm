#Baekjoon 7569 
import sys
from collections import deque
import numpy as np
input = sys.stdin.readline


def tomato():
    m, n, h = map(int, input().rstrip().split())

    box = []

    for _ in range(n):
        box.append(list(map(int, input().rstrip().split())))

    board = [box for _ in range(h)]
    visited = [[[0]*m for _ in range(n)] for _ in range(h)]
    print(np.array(visited))
    queue = deque()

    for i in range(n):
        for j in range(m):
            if box[i][j] == 1:
                for k in range(h):
                    queue.append([i, j, k])
                
    dx = [0, 0, 1, -1, 0, 0]
    dy = [1, -1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]
    
    while queue:
        x, y, z = queue.popleft()
        print(x, y, z)
        visited[x][y][z] = 1
        
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m or nz < 0 or nz >= h:
                continue
            
            if board[nx][ny][nz] == 0 and visited[nx][ny][nz] == 0:
                queue.append([nx, ny,nz])
                board[nx][ny][nz] = 1
    
    print(np.array(board))
    
tomato()