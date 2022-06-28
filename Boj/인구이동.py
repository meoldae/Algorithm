#Baekjoon 16234
import sys
from collections import deque
input = sys.stdin.readline

def solution(n, l, r):
    land = []
    for _ in range(n):
        land.append(list(map(int, input().split())))

    direction = [[1,0],[-1,0],[0,1],[0,-1]]
    count = 0
    
    while True:
        unions = []
        visited = [0]*(n**2)
        
        queue = deque()
        
        for row in range(n):
            for col in range(n):
                if visited[(row*n)+col] == 0:
                    visited[(row*n)+col] = 1        
                    queue.append([row, col])
                    union = set()
                    
                    while queue:
                        x, y = queue.popleft()
                        
                        for dx, dy in direction:
                            nx = x + dx
                            ny = y + dy

                            if nx >= n or nx < 0 or ny >= n or ny < 0:
                                continue
                            
                            if visited[(nx*n)+ny] == 0:                        
                                if l <= abs(land[x][y] - land[nx][ny]) <= r:
                                    queue.append([nx, ny])
                                    visited[(nx*n)+ny] = 1
                                    union.add((x, y))
                                    union.add((nx,ny))
                                    
                    if len(list(union)) > 0:
                        unions.append(list(union))
                        
        if len(unions) == 0:
            print(count)
            return 
        
        
        for u in unions:
            people = 0
            for x, y in u:
                people += land[x][y]
            
            for x, y in u:
                land[x][y] = people//len(u)
        
        count += 1
            
n, l, r = map(int, input().split())
solution(n, l, r)