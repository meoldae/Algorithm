#Baekjoon 21610
#삼성 SW 역량테스트 기출 문제
import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))

direction = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
cloud = deque([[n-2, 0], [n-2, 1], [n-1, 0], [n-1, 1]])

for _ in range(m):
    d, s = map(int, input().split())
    
    for i in range(len(cloud)):
        cr, cc = cloud.popleft()
        cr = (n + cr + direction[d-1][0]*s) % n
        cc = (n + cc + direction[d-1][1]*s) % n
        a[cr][cc] += 1
        cloud.append([cr, cc])
    
    visited = defaultdict(int)
    
    for _ in range(len(cloud)):
        r, c = cloud.popleft()
        visited[r, c] = 1    
        for j in range(1, 8, 2):
            nr = r + direction[j][0]
            nc = c + direction[j][1]
            
            if 0 <= nr < n and 0 <= nc < n:
                if a[nr][nc] > 0:
                    a[r][c] += 1 
    
    for i in range(n):
        for j in range(n):
            if visited[i, j] == 1:
                continue
            else:
                if a[i][j] >= 2:
                    cloud.append([i, j]) 
                    a[i][j] -= 2
    
answer = 0
for state in a:
    answer += sum(state)

print(answer)