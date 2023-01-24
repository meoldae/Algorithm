#Baekjoon 1504
import sys, heapq
input = sys.stdin.readline

def dijkstra(start, ver):
    q = []
    heapq.heappush(q, (0, start))
    distance[ver][start] = 0
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[ver][now] < dist:
            continue
        
        for i in range(len(graph[now])):
            total_cost = dist+graph[now][i]
            if total_cost < distance[ver][i]:
                distance[ver][i] = total_cost
                heapq.heappush(q, (total_cost, i))

n, e = map(int, input().split())
graph = [[1e9]*n for _ in range(n)]
distance = [[1e9] * n for _ in range(3)]
for i in range(e):
    a, b, c = map(int, input().split())
    graph[a-1][b-1] = c
    graph[b-1][a-1] = c

v1, v2 = map(int, input().split())

for i in range(n):
    graph[i][i] = 0

dijkstra(0, 0)
dijkstra(v1-1, 1)
dijkstra(v2-1, 2)

dist = min(distance[0][v1-1] + distance[1][v2-1] + distance[2][n-1], distance[0][v2-1] + distance[2][v1-1] + distance[1][n-1])

if dist < 1e9:
    print(dist)
else:
    print(-1)