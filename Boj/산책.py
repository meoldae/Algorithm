#Baekjoon 22868
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = defaultdict(list)
visited = []
for _ in range(m):
    a, b = map(int, input().split())
    
    graph[a].append(b)
    graph[b].append(a)
    
s, e = map(int, input().split())

count = 0

# Node, count, Visited
queue = deque([s, 0, visited])

while queue:
    