# Baekjoon 15685
import sys
input = sys.stdin.readline

n = int(input())

infos = []
points = set()
count = 0

for _ in range(n):
    infos.append(list(map(int, input().split())))

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

for x, y, d, g in infos:
    directions = [d]
    points.add((x, y))
    while g:
        l = len(directions)

        for i in range(l-1, 0-1, -1):
            directions.append((directions[i]+1)%4)
        
        g -= 1
    
    for d in directions:   
        nx = x + dx[d]
        ny = y + dy[d]

        x, y = nx, ny
        points.add((x, y))
        
for x, y in points:
    if ((x, y+1) in points) and ((x+1, y) in points) and ((x+1, y+1) in points):
        count += 1

print(count)