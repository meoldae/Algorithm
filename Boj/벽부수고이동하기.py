from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
visited = [[0]*m for i in range(n)]
board = []
answer_board = [[1e9]*m for i in range(n)]

for i in range(n):
    temp = list(map(int, list(input().rstrip())))
    board.append(temp)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

queue = deque() 
queue.append((0, 0, 1, 0)) # x, y, count, break_status
visited[0][0] = 1

while queue:
    x, y, count, status = queue.popleft()
    
    if x == n-1 and y == m-1:
        print(answer_board[x][y]+1)
        break
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if nx >= n or nx < 0 or ny >= m or ny < 0:
            continue
    
        elif board[nx][ny] == 0 and visited[nx][ny] == 0:
            visited[nx][ny] = 1
            answer_board[nx][ny] = min(answer_board[nx][ny], count)
            queue.append((nx, ny, count+1, status))
        
        elif board[nx][ny] == 1 and visited[nx][ny] == 0 and status == 0:
            visited[nx][ny] = 1
            answer_board[nx][ny] = min(answer_board[nx][ny], count)
            queue.append((nx, ny, count+1, 1))

if answer_board[n-1][m-1] == 1e9:
    print(-1)