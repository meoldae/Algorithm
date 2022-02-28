import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())
graph = [[] for i in range(n)]
visited = [False] * n
distance = [INF] * n

for i in range(m):
    start, end, cost = map(int, input().split())    
    graph[start-1].append((end-1, cost))
    

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
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

src, dst = map(int, input().split())
dijkstra(src-1)
print(distance[dst-1])