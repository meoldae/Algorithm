# Baekjoon 20056
import sys
from collections import deque
input = sys.stdin.readline

n, m, k = map(int, input().split())
queue = deque()

for _ in range(m):
    x, y, m, s, d = map(int, input().split())
    queue.append([x-1, y-1, m, s, d])
    
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
# Directions 0 ~ 7 

for _ in range(k):
    
    # Mass, Velocity, Direction, Count for Direction
    board = [[[0, 0, 0, 0]]*n for _ in range(n)]
    fireballs = set()
    
    # 파이어볼 이동 
    for j in range(len(queue)):
        x, y, m, s, d = queue.popleft()
        
        nx = (x + (dx[d]*s)) % n
        ny = (y + (dy[d]*s)) % n
                
        board[nx][ny] = [board[nx][ny][0]+m, board[nx][ny][1]+s, board[nx][ny][2]+(d % 2), board[nx][ny][3]+1]
        # 파이어볼 있는곳 좌표 저장 
        fireballs.add((nx, ny))
    
    # 이동 후
    for x, y in fireballs:
        m, s, d, count = board[x][y]
        
        # 한개면 그대로 큐에 추가
        if count == 1:
            queue.append((x, y, m, s, d))
    
        else:
            # 질량 0이면 소멸
            if m // 5:        
                if (d == count) or (d==0): # Directions are same
                    for a in range(0, 7, 2):
                        queue.append((x, y, m//5, s//count, a))
                else:
                    for a in range(1, 8, 2):
                        queue.append((x, y, m//5, s//count, a))


answer = 0
while queue:
    x, y, m, s, d = queue.popleft()
    answer += m
    
print(answer)