import numpy as np
from collections import deque
temp = []
n = 8 # Range of board

for i in range(n):
    temp.append(list(input()))

board = [[0]*n for _ in range(n)]

# board rotate
for i in range(n):
    for j in range(n):
        board[j][7-i] = temp[i][j]

visited = [[0]*n for _ in range(n)]
    
queue = deque()
queue.append((0, 0))

dx = [0, -1, 1, -1, 1]
dy = [1, 1, 1, 0, 0]
# Right, Right_Up, Right_Down, Down, Up

print(np.array(board))
while queue:
    x, y = queue.popleft()
    if x == n-1 and y == n-1:
        print(1)
        break
    
    for i in range(5):
        nx = x + dx[i]
        ny = y + dy[i]
    
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        
        elif board[nx][ny] == '.' and visited[nx][ny] == 0:
            if ny < 7:
                if board[nx][ny+1] == '.':
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
            else:
                print(1)
                break

else:
    print(0)