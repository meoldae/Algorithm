#Baekjoon 2665
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
board = []

for _ in range(n):
    board.append(list(map(int, str(input().rstrip()))))
    
visited = [[-1]*n for _ in range(n)]

queue = deque()
queue.append([0, 0]) 
visited[0][0] = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

    
while queue:
    x, y = queue.popleft()
    
    if (x, y) == (n-1, n-1):
        print(visited[n-1][n-1])
        break
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == 1:
                if visited[nx][ny] == -1:
                    visited[nx][ny] = visited[x][y]
                    queue.appendleft([nx, ny])  # 검은방 보다 흰 방이 우선순위가 높기 때문
            
            if board[nx][ny] == 0:
                if visited[nx][ny] == -1:
                    visited[nx][ny] = visited[x][y]+1
                    queue.append([nx, ny])