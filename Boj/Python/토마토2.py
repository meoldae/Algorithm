#Baekjoon 7569 
import sys
from collections import deque
input = sys.stdin.readline

def tomato():
    m, n, h = map(int, input().rstrip().split())

    board = []

    for _ in range(h):
        box = []
        for _ in range(n):
            box.append(list(map(int, input().rstrip().split())))
        board.append(box)

    visited = [[[0]*m for _ in range(n)] for _ in range(h)]
    queue = deque()

    for k in range(h):
        for i in range(n):
            for j in range(m):
                if board[k][i][j] == 1:
                    queue.append([k, i, j])
    
    dx = [0, 0, 1, -1, 0, 0]
    dy = [1, -1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]
    
    count = 0
    while queue:
        
        for _ in range(len(queue)):
            z, x, y = queue.popleft()
            visited[z][x][y] = 1
                    
            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]
                
                if nx < 0 or nx >= n or ny < 0 or ny >= m or nz < 0 or nz >= h:
                    continue
                
                if board[nz][nx][ny] == 0 and visited[nz][nx][ny] == 0:
                    queue.append([nz, nx, ny])
                    board[nz][nx][ny] = 1
                    visited[nz][nx][ny] = 1
        count += 1
    
    for floor in board:
        for box in floor:
            if 0 in box:
                return -1
    else:
        return count-1
    
print(tomato())