#Baekjoon 7562
import sys
from collections import deque
input = sys.stdin.readline

def bfs(n, src, dst):
    visited = [[0]*n for _ in range(n)]
    queue = deque()
    queue.append([src[0], src[1]])
    
    visited[src[0]][src[1]] = 1
    
    # 시계방향으로
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]
    
    while queue:
        x, y = queue.popleft()
            
        if [x, y] == dst:
            return visited[x][y]
        
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            
            if visited[nx][ny] == 0:
                queue.append([nx, ny])
                visited[nx][ny] = visited[x][y]+1
    return

t = int(input())
for _ in range(t):
    n = int(input().rstrip())
    src = list(map(int, input().rstrip().split()))
    dst = list(map(int, input().rstrip().split()))
    print(bfs(n, src, dst)-1)