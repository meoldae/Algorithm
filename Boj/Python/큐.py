import sys
from collections import deque
input = sys.stdin.readline
n = int(input())

queue = deque()
for i in range(n):
    temp = list(input().split())
    
    if temp[0] == 'push':
        queue.append(int(temp[1]))
    
    elif temp[0] == 'pop':
        if queue: print(queue.popleft())
        else: print(-1)
    
    elif temp[0] == 'size':
        print(len(queue))
        
    elif temp[0] == 'empty':
        if queue: print(0)
        else: print(1)
    
    elif temp[0] == 'front':
        if queue: print(queue[0])
        else: print(-1)
    
    elif temp[0] == 'back':
        if queue: print(queue[-1])
        else: print(-1)