#Baekjoon 1922
import sys, heapq
input = sys.stdin.readline

def find(x):
    global p
    if p[x] != x:
        p[x] = find(p[x])
        return p[x]
    return x

def union(x, y):
    x = find(x)
    y = find(y)
    if x < y:
        p[y] = x
    else:
        p[x] = y
    return 

def isSameParent(x, y):
    if find(x) == find(y):
        return True
    return False

if __name__ == '__main__':
    n = int(input())
    m = int(input())

    p = [i for i in range(n)]

    graph = []
    answer = 0 
    for _ in range(m):
        a, b, c = map(int, input().split())
        heapq.heappush(graph, [c, a-1, b-1])

    while graph:
        cost, start, end = heapq.heappop(graph)
        if not isSameParent(start, end):
            union(start, end)
            answer += cost
    print(answer)