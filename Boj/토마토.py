import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
visited = [[0 for i in range(m)]for j in range(n)]

board = []
for i in range(n):
    board.append(list(map(int, input().split())))
    
queue = deque()

for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            queue.append((i, j, 1))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

time = 0
while queue:
    x, y, day = queue.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        
        elif board[nx][ny] == 0 and visited[nx][ny] == 0:
            board[nx][ny] = 1
            visited[nx][ny] = 1
            time = max(day, time)
            queue.append((nx, ny, day+1))
            
check = True
           
for i in range(n):
    if 0 in board[i]:
        check = False
        break

if check:
    print(time)
else:
    print(-1) 