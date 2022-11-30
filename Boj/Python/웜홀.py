#Baekjoon 1865
import sys
input = sys.stdin.readline

tc = int(input())

def floyd():
    global graph, n 
    
    for i in range(n):
        if graph[i][i] < 0: # 제자리 웜홀
            return True
        for j in range(n):
            for k in range(n):
                graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])
                if graph[j][k] + graph[k][j] < 0:
                    return True
    return False

for _ in range(tc):
    n, m, w = map(int, input().split())
    
    graph = [[10001]*n for _ in range(n)]
    
    for _ in range(m):
        s, e, t = map(int, input().split())
        if graph[s-1][e-1] > t:
            graph[s-1][e-1] = t
            graph[e-1][s-1] = t
    
    for _ in range(w):
        s, e, t = map(int, input().split())
        if graph[s-1][e-1] > -t:
            graph[s-1][e-1] = -t
            
    if floyd():
        print('YES')
    else:
        print('NO')