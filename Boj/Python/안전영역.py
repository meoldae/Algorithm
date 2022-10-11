#Baekjoon 2468
import sys
from collections import deque
input = sys.stdin.readline

def bfs(row, col, height):
    global visited
    global board
    global n
    queue = deque()
    queue.append([row, col])
    visited[row*n + col] = 1
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    while queue:
        r, c = queue.popleft()
        
        for i in range(4):
            nx = r + dx[i]
            ny = c + dy[i]
            
            if nx >= 0 and nx < n and ny >= 0 and ny < n:
                if board[nx*n + ny] > height and visited[nx*n + ny] == 0:
                    queue.append([nx, ny])
                    visited[nx*n + ny] = 1
    return

n = int(input())
board = []
answer = 0

for _ in range(n):
    temp = list(map(int, input().split()))
    board.extend(temp)

minVal = min(board)
maxVal = max(board)

answer = 0
for h in range(minVal-1, maxVal+1):
    visited = [0]*(n**2)
    id = 1
    for row in range(n):
        for col in range(n):
            if visited[row * n + col] == 0 and board[row * n + col] > h:
                bfs(row, col, h)
                id += 1
    
    answer = max(answer, id)

print(answer-1)