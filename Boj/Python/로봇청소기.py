#Baekjoon 14503
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
x, y, d = map(int, input().split())

queue = deque()
queue.append([x, y])

board = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(n):
    board.append(list(map(int, input().rstrip().split())))

count = 0
cnt = 0
while queue:
    x, y = queue.popleft()
    
    if board[x][y] == 0:
        board[x][y] = 2
        cnt += 1
    
    if count >= 4:
        nx = x - dx[d]    
        ny = y - dy[d]
        if board[nx][ny] == 1:
            break
        else:
            count = 0
            queue.append([nx, ny])
            continue
    
    d -= 1
    if d < 0:
        d = 3
        
    nx = x + dx[d]
    ny = y + dy[d]
    
    if board[nx][ny] == 0:
        count = 0
        queue.append([nx, ny])
    else:
        queue.append([x, y])
        count += 1
        continue
print(cnt)