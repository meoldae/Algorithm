from collections import deque
import sys

n = int(input())
board = [[] for i in range(n)]
answer = []
for i in range(n):
    temp = sys.stdin.readline()
    for j in range(n):
        board[i].append(int(temp[j]))
        
visited = [[0]*n for i in range(n)]

queue = deque()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
cnt = 1
for i in range(n):
    for j in range(n):
        if visited[i][j] == 1 or board[i][j] == 0:
            continue
        else:
            queue.append((i, j))
            cnt += 1     
            count = 1
            while queue:
                x, y = queue.popleft()
                
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if nx >= n or nx < 0 or ny >= n or ny < 0:
                        continue

                    elif visited[nx][ny] == 0 and board[nx][ny] == 1:
                        queue.append((nx, ny))
                        count += 1
                        visited[nx][ny] = 1
                        board[nx][ny] = cnt
            answer.append(count)
answer.sort()
print(len(answer))
for i in range(len(answer)):
    if answer[i] != 1:
        print(answer[i]-1)
    else:
        print(answer[i])