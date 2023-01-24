#Baekjoon 1707
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    v, e = map(int, input().split())
    graph = [[] for _ in range(v+1)]
    for _ in range(e):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    print(graph)

