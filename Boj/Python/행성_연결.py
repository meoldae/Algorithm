#Baekjoon 16398
import sys
input = sys.stdin.readline

def find(x):
    if x == p[x]:
        return x
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

n = int(input())

graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))
    

p = [i for i in range(n)]

mst = []

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        else:
            mst.append([i, j, graph[i][j]])

mst.sort(key = lambda x : x[2])

answer = 0

for x, y, c in mst:
    if not isSameParent(x, y):
        union(x, y)
        answer += c

print(answer)