#Baekjoon 1058
import sys
input = sys.stdin.readline

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))
    
relation = [[0]*n for _ in range(n)]

for i in range(n):
    for j in range(n):
        for k in range(n):
            if j == k:
                continue
            if graph[j][k] == 'Y':
                relation[j][k] = 1
            else:
                if graph[j][i] == 'Y' and graph[i][k] == 'Y':
                    relation[j][k] = 1
answer = 0
for friend in relation:
    answer = max(answer, friend.count(1))
print(answer)