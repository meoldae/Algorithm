from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = []
visited = [[0]*m for i in range(n)]

x, y = 0, 0
for i in range(n):
    temp = list(map(int, input().split()))
    if 2 in temp:
        first_x = i
        first_y = temp.index(2)
    board.append(temp)

queue = deque()

queue.append((first_x, first_y, 0))
board[first_x][first_y] = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

while queue:
    x, y, cnt = queue.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx >= n or nx < 0 or ny >= m or ny < 0:
            continue
        
        elif visited[nx][ny] == 0 and board[nx][ny] == 1:
            board[nx][ny] = cnt + 1
            visited[nx][ny] = 1
            queue.append((nx, ny, cnt+1))

for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and (abs(first_x-i)+abs(first_y-j))>1:
            board[i][j] = -1

for i in range(n):
    print(' '.join(map(str, board[i])))