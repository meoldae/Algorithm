from dis import dis
import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

v, e = map(int, input().split())
k = int(input())-1
graph = [[] for i in range(v)]
visited = [False] * v
distance = [INF] * v

# 간선정보 기입
for i in range(e):
    start, end, cost = map(int, input().split())
    graph[start-1].append((end-1, cost))



def dijkstra(start):
    q = []
    heapq.heappush(q,(0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            total_cost = dist+i[1]
            if total_cost < distance[i[0]]:
                distance[i[0]] = total_cost
                heapq.heappush(q, (total_cost, i[0]))
        

dijkstra(k)            
for i in distance:
    if i == INF:
        print('INF')
    else:
        print(i)