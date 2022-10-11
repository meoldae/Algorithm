#Baekjoon 11265
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(n):
        for k in range(n):
            if graph[j][k] > graph[j][i] + graph[i][k]:
                graph[j][k] = graph[j][i] + graph[i][k]
        
for _ in range(m):
    src, dst, time = map(int, input().split())

    if graph[src-1][dst-1] <= time:
        print("Enjoy other party")
        
    else:
        print("Stay Here")