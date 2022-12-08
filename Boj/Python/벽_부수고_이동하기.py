#Baekjoon 2206
from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
visited = [[[0]*m for _ in range(n)] for _ in range(2)]
board = []

for i in range(n):
    temp = list(map(int, list(input().rstrip())))
    board.append(temp)


def bfs():
    queue = deque() 
    queue.append([0, 0, 0])

    while queue:
        x, y, flag = queue.popleft()
        
        if x == n-1 and y == m-1:
            return visited[flag][x][y]+1
        
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0] 
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == 0 and visited[flag][nx][ny] == 0:
                    visited[flag][nx][ny] = visited[flag][x][y] + 1
                    queue.append([nx, ny, flag])
                    
                elif board[nx][ny] == 1 and flag == 0:
                    visited[1][nx][ny] = visited[0][x][y] + 1
                    queue.append([nx, ny, 1])
    else:
        return -1

print(bfs())