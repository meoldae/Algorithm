#Baekjoon 1389
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[1e9]*n for _ in range(n)]

for i in range(n):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    
    graph[a-1][b-1] = 1
    graph[b-1][a-1] = 1

for i in range(n):
    for j in range(n):
        for k in range(n):
            graph[j][k] = min(graph[j][k], graph[j][i]+graph[i][k])
            
answer = [sum(graph[i]) for i in range(len(graph))]
print(answer.index(min(answer))+1)    