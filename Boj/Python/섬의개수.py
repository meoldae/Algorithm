#Baekjoon 4963
import sys
from collections import deque
input = sys.stdin.readline
answer = []

def bfs(w, h):  
    global answer 
    board = []
    
    for _ in range(h):
        temp = list(map(int, input().split()))
        board.append(temp)
    
    queue = deque()
    
    visited = [[0]*w for _ in range(h)]
    
    count = 1
    
    dx = [0, 0, -1, 1, -1, -1, 1, 1]
    dy = [1, -1, 0, 0, -1, 1, -1, 1]
    
    for row in range(h):
        for col in range(w):
            if board[row][col] == 1 and visited[row][col] == 0:
                queue.append([row, col])
                visited[row][col] = count
                while queue:
                    x, y = queue.popleft()
                    
                    for i in range(8):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        
                        if nx >= h or nx < 0 or ny >= w or ny < 0:
                            continue

                        if board[nx][ny] == 1 and visited[nx][ny] == 0:
                            visited[nx][ny] = count
                            queue.append([nx, ny])
                            
                count += 1
    max_val = 0
    for lst in visited:
        max_val = max(max_val, max(lst))
    print(max_val)

w, h = map(int, input().split())

while w != 0 and h != 0:
    bfs(w, h)
    w, h = map(int, input().split())