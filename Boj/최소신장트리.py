#Baekjoon 1197
import sys
import heapq
from collections import defaultdict
input = sys.stdin.readline

v, e = map(int, input().split())

# Cruscal Algorythm (Union Find)
# Parents 
p = [i for i in range(v)]

def find(x):
    if x == p[x]:
        return x;
    else:
        p[x] = find(p[x])
        return p[x]

def union(x, y):
    x = find(x)
    y = find(y)
    
    if x != y:
        p[y] = x
    return

def isSameParent(x, y):
    x = find(x)
    y = find(y)
    
    if x == y:
        return True
    else:
        return False

graph = []

for _ in range(e):
    a, b, c = map(int, input().split())
    graph.append([a-1, b-1, c])
   
graph.sort(key= lambda x:x[2])

answer = 0

for i in range(len(graph)):
    a, b, c = graph[i]
    if not isSameParent(a, b):
        union(a, b)
        answer += c

print(answer)