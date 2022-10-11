#Baekjoon 10026
import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n = int(input())

board = []
visited = [[[0, 0] for _ in range(n)] for _ in range(n)]
answer = defaultdict(int)

for _ in range(n):
    board.append(input().rstrip())
    
queue = deque()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(i, j, num):
    queue.append([i, j])
    visited[i][j][num] = 1
    
    color = board[i][j]
    if num:
        if color in ['R', 'G']:
            color = ['R', 'G']
    
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >= n or nx < 0 or ny >= n or ny < 0:
                continue
            
            if board[nx][ny] in color and visited[nx][ny][num] == 0:
                visited[nx][ny][num] = 1
                queue.append([nx, ny])

    return

for i in range(n):
    for j in range(n):
        for k in range(2):
            if visited[i][j][k] == 0:
                bfs(i, j, k)
                answer[k] += 1

print(answer[0], answer[1])