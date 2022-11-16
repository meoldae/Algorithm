#Baekjoon 2458
import sys
import numpy as np
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[0]*n for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1

    
for i in range(n):
    for j in range(n):
        for k in range(n):
            if graph[j][i] == 1 and graph[i][k] == 1:
                graph[j][k] = 1

answer = 0
for row in range(n):
    me = 0
    for col in range(n):
        me += graph[row][col] + graph[col][row]
        
    if me == n-1:
        answer += 1
    
print(answer)