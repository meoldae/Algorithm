#Baekjoon 2589
import sys
from collections import deque
input = sys.stdin.readline

def solution():
    n, m = map(int, input().split())
    visited = [[0]*m for _ in range(n)]
    board = []

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    for _ in range(n):
        board.append(list(input().rstrip()))
    
    count = 0
    for row in range(n):
        for col in range(m):
            
            if board[row][col] == 'L':
                visited = [[0]*m for _ in range(n)]
                queue = deque()
                queue.append((row, col))
                visited[row][col] = 1
                temp_count = 0
                
                while queue:
                    x, y = queue.popleft()
                    
                    for i in range(4):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        
                        if nx < 0 or nx >= n or ny < 0 or ny >= m:
                            continue
                        
                        elif board[nx][ny] == 'L' and visited[nx][ny] == 0:
                            queue.append((nx, ny))
                            visited[nx][ny] = visited[x][y]+1
                            temp_count = max(temp_count, visited[nx][ny])
                
                count = max(count, temp_count-1)
            
    return count
print(solution())