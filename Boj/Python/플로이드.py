#Baekjoon 11404
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[1e9]*n for _ in range(n)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a-1][b-1] = min(graph[a-1][b-1], c)

for i in range(n):
    graph[i][i] = 0
    for j in range(n):
        for k in range(n):
            graph[j][k] = min(graph[j][k], graph[j][i]+graph[i][k])

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1e9:
            graph[i][j] = 0

for city in graph:
    print(*city)