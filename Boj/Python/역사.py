#Baekjoon 1613
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

graph = [[100000] * n for _ in range(n)]

for _ in range(n):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1;

for i in range(n):
    for j in range(n):
        for z in range(n):
            if j == z:
                graph[j][z] == 0
            else:
                graph[j][z] = min(graph[j][z], graph[j][i] + graph[i][z])

s = int(input())
for _ in range(s):
    c, d = map(int, input().split());
    c -= 1
    d -= 1
    if graph[c][d] == 100000 and graph[d][c] == 100000:
        print(0)
    elif graph[c][d] < graph[d][c]:
        print(-1)
    else:
        print(1)