#Baekjoon 14889
#삼성 SW 역량테스트 기출 문제
import sys
from collections import deque
input = sys.stdin.readline

def diffusion():
    global room
    dx, dy = (-1, 1, 0, 0), (0, 0, -1, 1)
    diffused = [[0] * c for _ in range(r)]

    for x in range(r):
        for y in range(c):
            if room[x][y] == 0 or room[x][y] == -1:
                continue

            dust = room[x][y] // 5

            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]

                if [nx, ny] in airConditioner:
                    continue
                
                if 0 <= nx < r and 0 <= ny < c:
                    diffused[nx][ny] += dust
                    diffused[x][y] -= dust

    for i in range(r):
        for j in range(c):
            room[i][j] += diffused[i][j]


def airRotationTop():
    global airConditioner, room
    
    x, y = airConditioner[0]
    direction = 0
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    
    queue = deque()
    
    x += dx[direction]
    y += dy[direction]
    
    queue.append((x, y))
    
    while queue:
        x, y = queue.popleft()
        
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        if (nx == 0 and (ny == 0 or ny == c-1)) or (nx == airConditioner[0][0] and (ny == 0 or ny == c-1)):
            direction = (direction+1)%4
            
            if [nx, ny] == airConditioner[0]:
                room[x][y] = 0
                return
            
            room[x][y] = room[nx][ny]
            queue.append([nx, ny])
            continue
        
        room[x][y] = room[nx][ny]
        queue.append([nx, ny])
            
    return
def airRotationBottom():
    global airConditioner, room
    
    x, y = airConditioner[1]
    direction = 0
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    queue = deque()
    
    x += dx[direction]
    y += dy[direction]
    
    queue.append((x, y))
    
    while queue:
        x, y = queue.popleft()
        
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        if (nx == r-1 and (ny == 0 or ny == c-1)) or (nx == airConditioner[1][0] and (ny == 0 or ny == c-1)):
            direction = (direction+1)%4
            
            if [nx, ny] == airConditioner[1]:
                room[x][y] = 0
                return
            
            room[x][y] = room[nx][ny]
            queue.append([nx, ny])
            continue
        
        room[x][y] = room[nx][ny]
        queue.append([nx, ny])
            
    return

r, c, t = map(int, input().split())
queue = deque()
room = []
airConditioner = []

for i in range(r):
    temp = list(map(int, input().split()))
    
    if -1 in temp:
        airConditioner.append([i, temp.index(-1)])
        temp[temp.index(-1)] = 0

    for j in range(len(temp)):
        if temp[j] > 0:
            queue.append((i, j))
    room.append(temp)

time = 0
while time < t:
    diffusion()
    airRotationTop()
    airRotationBottom()
    time += 1
    
answer = 0
for row in room:
    answer += sum(row)
print(answer)