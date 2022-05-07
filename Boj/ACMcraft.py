#Baekjoon 1005
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

t = int(input())

def bfs(order, start, indegree):
    global values
    tmp_ind = indegree[::]
    queue = deque()
    queue.append(start)
    values[start] = max(values[start], times[start-1])

    while queue:  
        for i in range(len(queue)):
            node = queue.popleft()

            
            for i in order[node]:
                tmp_ind[i] -= 1
                values[i] = max(values[i], values[node]+times[i-1])
                if tmp_ind[i] == 0:
                    queue.append(i)

    return

for _ in range(t):
    n, k = map(int, input().split())
    times = list(map(int, input().split()))
    values = [0]*(n+1)
    
    order = defaultdict(list)
    indegree = [0]*(n+1)
    
    for _ in range(k):
        x, y = map(int, input().split())    
        order[x].append(y)
        indegree[y] += 1
        
    w = int(input())
    
    values = [0]*(n+1)
    
    for i in range(1, n+1):
        if indegree[i] == 0:
            bfs(order, i, indegree) 

    print(values[w])