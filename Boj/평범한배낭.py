#Baekjoon 12865
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

infos = [[0, 0]]
pack = [[0]*(k+1) for _ in range(n+1)]

for _ in range(n):
    w, v = map(int, input().split())
    infos.append([w, v])

for row in range(1, n+1):
    for col in range(1, k+1):
        w, v = infos[row]
        
        if col < w:
            pack[row][col] = pack[row-1][col]
        else:
            pack[row][col] = max(v + pack[row-1][col-w], pack[row-1][col])
            
print(pack[n][k])