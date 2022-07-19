#Baekjoon 14891
import sys
from collections import deque
input = sys.stdin.readline

def rotation(commands):
    global gears
    for idx, command in enumerate(commands):
        if command == 1:
            temp = gears[idx].pop()
            gears[idx].appendleft(temp)
        elif command == -1:
            temp = gears[idx].popleft()
            gears[idx].append(temp)
    return

def directionCheck(queue:deque):
    global gears 
    visited = [0] * 4
    
    while queue:
        now, head = queue.popleft()
        visited[now] = head
        
        for d in [+1, -1]:
            next = now + d
            
            if next < 0 or next >= 4:
                continue
            
            if d == 1 and visited[next] == 0: # 우측 톱니 확인
                if gears[now][2] != gears[next][6]:
                    visited[next] = head*-1
                    queue.append([next, head*-1])
                
            if d == -1 and visited[next] == 0:  # 좌측 톱니 확인
                if gears[now][6] != gears[next][2]:
                    visited[next] = head*-1
                    queue.append([next, head*-1])
                    
    return visited

gears = []

flags = [0]*4
for _ in range(4):
    gears.append(deque(map(int, list(input().rstrip()))))

k = int(input())

for _ in range(k):
    order, flag = map(int, input().split())   
        
    queue = deque([(order-1, flag)])
    
    command = directionCheck(queue)
    rotation(command)
    
answer = 0
for i in range(len(gears)):
    answer += gears[i][0]*(2**i)

print(answer)