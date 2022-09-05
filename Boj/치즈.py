#Baekjoon 2636
import sys
from collections import deque
from copy import deepcopy
input = sys.stdin.readline

def contactAir(n, m, board):
    queue = deque()
    queue.append([0, 0])
    visited = [[0]*m for _ in range(n)]
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    c = []
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):    
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == 0:
                    if board[x][y] == 0 and board[nx][ny] == 1:
                        c.append([nx, ny])
                        visited[nx][ny] = 1
                    elif board[nx][ny] == 0:
                        queue.append([nx, ny])
                        visited[nx][ny] = 1                    
    return c
    
n, m = map(int, input().split())

board = []

for _ in range(n):
    board.append(list(map(int, input().split())))
time = 0
contacted = contactAir(n, m, board)
while len(contacted):
    last = deepcopy(board)
    for x, y in contacted:
        board[x][y] = 0
    contacted = contactAir(n, m, board)
    time += 1
    
count = 0
for i in range(n):
    for j in range(m):
        if last[i][j] == 1:
            count += 1
print(time)
print(count)