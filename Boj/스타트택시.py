#Baekjoon 19238
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

global p
global board
global infos
n, m, p = map(int, input().split())
board = []
infos = defaultdict(list)

for _ in range(n):
    temp = list(map(int, input().split()))
    board.append(temp)

start_x, start_y = map(int, input().split())
start_x -= 1
start_y -= 1

for i in range(m):
    a, b, c, d = map(int, input().split())
    
    board[a-1][b-1] = 2
    infos[a-1, b-1] = [c-1, d-1]
    
def bfs(x, y):
    error = [1e9, 1e9, 1e9, 1e9]
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]    

    queue = deque()
    passengers = []
    
    if (x, y) in infos:
        queue.clear()
        passengers.append([x, y, 0])
    else:
        queue.append([x, y, 0])
        
    visited = [0]*(n**2)
    visited[(x*n)+y] = 1
    
    dist = 1e9
    
    # 승객 찾기
    while queue:
        x, y, cnt = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >= n or nx < 0 or ny >= n or ny < 0:
                continue
            
            if board[nx][ny] == 2 and visited[(nx*n)+ny] == 0:
                dist = min(dist, cnt+1)
                
                # 최단거리인 승객들 추가
                if (cnt+1) == dist:
                    passengers.append([nx, ny, cnt+1])
                    visited[(nx*n)+ny] = 1
            
            elif board[nx][ny] != 1 and visited[(nx*n)+ny] == 0:
                queue.append([nx, ny, cnt+1])
                visited[(nx*n)+ny] = 1
    
    if len(passengers) == 0:
        return error
    
    # 최상단, 좌측 고객 선정
    passengers.sort(key=lambda x:(x[0], x[1]))
    
    # 손님 제거
    board[passengers[0][0]][passengers[0][1]] = 0
    
    # 목적지 추출
    dst_x, dst_y = infos[passengers[0][0], passengers[0][1]]

    # 추출 후 Dict에서 삭제
    del infos[passengers[0][0], passengers[0][1]]
    
    # 큐에 추가
    queue.append([passengers[0][0], passengers[0][1], passengers[0][2]])
    
    # 방문처리
    visited = [0]*(n**2)
    visited[(passengers[0][0]*n)+passengers[0][1]] = 1    
    
    # 목적지 까지 탐색
    while queue:
        x, y, cnt = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >= n or nx < 0 or ny >= n or ny < 0:
                continue
            
            # if [nx, ny] == [dst_x, dst_y] 틀린 이유... 도착지가 벽일 때 정상결과 나옴
            if [nx, ny] == [dst_x, dst_y] and board[nx][ny] != 1:
                return [nx, ny, cnt+1, cnt+1 - passengers[0][2]]
            
            elif board[nx][ny] != 1 and visited[(nx*n)+ny] == 0:
                queue.append([nx, ny, cnt+1])
                visited[(nx*n)+ny] = 1
    else:
        return error

for _ in range(m):

    temp = bfs(start_x, start_y)
    
    if p - temp[2] < 0:
        print(-1)
        break
    else:
        # 연료 소비
        p -= temp[2]
        # 출발지 반영
        start_x = temp[0] 
        start_y = temp[1]
        # 연료 충전
        p += temp[3]*2
else:
    print(p)