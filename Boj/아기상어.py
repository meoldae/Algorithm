#Baekjoon 16236
import sys
from collections import deque
input = sys.stdin.readline

n = int(input().rstrip())

global shark, stack
global board     
global queue

shark = 2   # Start Shark's size
stack = 2   # Shark should be eat
   
board = []
    
for i in range(n):
    temp = list(map(int, input().split()))        
    board.append(temp)
        
    # Start Location
    if 9 in temp:
        start_x = i
        start_y = temp.index(9)
        board[start_x][start_y] = 0

queue = deque()
queue.append([start_x, start_y, 0])

def bfs():   
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1] 
    dist = 1e9
    
    answers = []
    visited = [0]*(n**2)
    visited[(start_x*n)+start_y] = 1
    
    while queue:
        x, y, cnt = queue.popleft()    
        
        for i in range(4):
                    
            nx = x + dx[i]
            ny = y + dy[i]
                    
            if nx >= n or nx < 0 or ny >= n or ny < 0:
                continue
                    
            # Eat Fish
            if 0 < board[nx][ny] < shark: 
                dist = min(dist, cnt+1)     # 최단거리 반영 위함
                        
                if (cnt+1) == dist:         # 최단거리인 애들 다 추가
                    answers.append([nx, ny, cnt+1])
                    visited[(nx*n)+ny] = 1
                        
            elif board[nx][ny] == shark or board[nx][ny] == 0:
                if visited[(nx*n)+ny] == 0:
                    queue.append([nx, ny, cnt+1])
                    visited[(nx*n)+ny] = 1
    
    return answers  # 먹을 수 있는 최단거리 애들 반환

answer = 0

while True:
    temp = bfs()
    if len(temp) == 0:  # 먹을 수 있는 것 없으면 ?
        print(answer)
        break
    
    else:
        temp.sort(key=lambda x: (x[0], x[1]))       # 최상단 좌측 물고기
        answer += temp[0][2]                        # Count +
        board[temp[0][0]][temp[0][1]] = 0           # 먹은 물고기 반영
        start_x, start_y = temp[0][0], temp[0][1]
        queue.clear()                               # Queue 비우고 새로 탐색
        queue.append([temp[0][0], temp[0][1], 0])   # 새 좌표로 시작
        stack -= 1                                  # Shark 크기 반영
        if stack == 0:                              # 다먹었으면 상어 크기 + 1
            shark += 1
            stack = shark