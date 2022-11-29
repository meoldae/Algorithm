#Baekjoon 1167
import sys
from collections import defaultdict, deque

input = sys.stdin.readline

def dfs(now, cost):
    global answer, second
    
    for v, e in tree[now]:
        if visited[v] == 0:
            visited[v] = 1
            if answer < cost+e:
                second = v
                answer = cost + e
            dfs(v, cost+e)
            
    return

n = int(input())
tree = defaultdict(list)

for _ in range(n):
    graph = deque(list(map(int, input().split())))
    
    src = graph.popleft()
    
    while graph:
        dst = graph.popleft()
        if dst == -1:
            break
        else:
            cost = graph.popleft()
            tree[src-1].append([dst-1, cost])

answer = 0
first = 0
second = 0

visited = [0] * n
visited[first] = 1
dfs(first, 0)
visited = [0] * n
visited[second] = 1
dfs(second, 0)

print(answer)