#Baekjoon 1240
import sys, heapq
from collections import defaultdict, deque
input = sys.stdin.readline

# def bfs(graph, start, end):
#     answer = []
#     visited = [0] * (n+1)
#     queue = deque()
#     queue.append([start, 0])
    
#     while queue:
#         node, distance = queue.popleft()
        
#         visited[node] = 1
        
#         for next in graph[node]:            
#             if visited[next] == 0 and next != end:
#                 distance += graph[node][next]
#                 queue.append([next, distance])
                
#             elif visited[next] == 0 and next == end:
#                 answer.append(distance + graph[node][next])
                
#     print(min(answer))    
#     return
def dijkstra(n, graph, start, end):
    q = []
    distance = [1e9]*(n+1)
    heapq.heappush(q, (start, 0))
    distance[start] = 0
    
    while q:
        node, dist = heapq.heappop(q)
        
        if distance[node] < dist:
            continue
        
        for next in graph[node]:
            total = dist + graph[node][next]
            if total < distance[next]:
                distance[next] = total
                heapq.heappush(q, (next, total)) 
    print(distance[end])
    return 

n, m = map(int, input().split())
graph = defaultdict(dict)

for _ in range(n-1):
    s, e, c = map(int, input().split())
    
    graph[s][e] = c
    graph[e][s] = c

for _ in range(m):
    start, end = map(int, input().split())
    
    # bfs(graph, start, end)
    # BFS 9%에서 Fail
    
    dijkstra(n, graph, start, end)