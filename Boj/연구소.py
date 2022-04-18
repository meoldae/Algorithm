#Baekjoon 14502
import sys
import copy
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())

board = []
queue = deque()
count = 0

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
virus = []
for i in range(n):
    temp = list(map(int, input().rstrip().split()))
    viruses = list(filter(lambda x: temp[x] == 2, range(len(temp))))
    for j in viruses:
        virus.append([i, j])
    board.append(temp)

def bfs(queue):
    global count
    temp_board = copy.deepcopy(board)

    temp_count = 0
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
                
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            
            if temp_board[nx][ny] == 0:
                temp_board[nx][ny] = 2
                queue.append([nx, ny])
    
    for row in temp_board:
        temp_count += row.count(0)
    
    count = max(count, temp_count)   
    return

def wall(walls):
    if walls == 3:
        queue = deque(virus)
        bfs(queue)
        return
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                board[i][j] = 1
                wall(walls+1)
                board[i][j] = 0
                
wall(0)
print(count)