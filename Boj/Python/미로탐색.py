import sys
from collections import deque 

N, M = map(int, input().split())

board = []
visited = [[0]*M for i in range(N)]

for i in range(N):  # make Board
    board.append(list(sys.stdin.readline().rstrip()))

queue = deque()
queue.append((0, 0, 1))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

temp = 0
while queue:
    x, y, cnt = queue.popleft()

    if (x, y) == (N-1, M-1):
        print(cnt)
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= N or nx < 0 or ny >= M or ny < 0:
            continue

        elif board[nx][ny] == '1' and visited[nx][ny] == 0:
            queue.append((nx, ny, cnt+1))
            visited[nx][ny] = 1
