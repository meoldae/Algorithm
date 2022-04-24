#Baekjoon 1005
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, k = map(int, input().split())
    times = list(map(int, input().split()))
    
    order = defaultdict(list)
    indegree = [0]*(n+1)
    
    for _ in range(k):
        x, y = map(int, input().split())    
        order[x].append(y)
        indegree[y] += 1
        
    w = int(input())
    queue = deque()
    
    for i in range(1, n+1):
        if indegree[i] == 0:
            queue.append(i)
    
    result = []
    while queue:  
        temp = []
        for i in range(len(queue)):
            node = queue.popleft()
            temp.append(node)        
            
            for i in order[node]:
                indegree[i] -= 1
                
                if indegree[i] == 0:
                    queue.append(i)
        
        result.append(temp)            
            
    time = 0
    for o in result:
        temp = [times[i-1] for i in o]
        time += max(temp)
        if w in o:            
            print(time)
            break