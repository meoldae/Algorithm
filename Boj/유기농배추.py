from collections import deque
import sys
input = sys.stdin.readline

def find_cabbage(m, n, k):
    answer = 0
    board = [[0 for i in range(m)] for j in range(n)]
    visited = [[0 for i in range(m)] for j in range(n)]
    queue = deque()
    
    for a in range(k):
        x, y = map(int, input().split())
        board[y][x] = 1
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    for i in range(n):
        for j in range(m):
            check = False
            if board[i][j] == 1 and visited[i][j] == 0:
                queue.append((i, j))
                check = True

                while queue:
                    x, y = queue.popleft()

                    for b in range(4):
                        nx = x + dx[b]
                        ny = y + dy[b]
                    
                        if nx < 0 or nx >= n or ny < 0 or ny >= m:
                            continue
                    
                        elif board[nx][ny] == 1 and visited[nx][ny] == 0:
                            queue.append((nx, ny))
                            visited[nx][ny] = 1
            if check:
                answer += 1    
            
    return answer

t = int(input())

answer = []
for i in range(t):
    m, n, k = map(int, input().split())
    answer.append(find_cabbage(m, n, k))
    
for i in range(len(answer)):
    print(answer[i])