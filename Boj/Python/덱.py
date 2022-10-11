import sys
from collections import deque
input = sys.stdin.readline
n = int(input())

de_queue = deque()
for i in range(n):
    temp = list(input().split())
    
    if temp[0] == 'push_front':
        de_queue.appendleft(int(temp[1]))
        
    elif temp[0] == 'push_back':
        de_queue.append(int(temp[1]))   
    
    elif temp[0] == 'pop_front':
        if de_queue: print(de_queue.popleft())
        else: print(-1)
    
    elif temp[0] == 'pop_back':
        if de_queue: print(de_queue.pop())
        else: print(-1)
    
    elif temp[0] == 'size':
        print(len(de_queue))
        
    elif temp[0] == 'empty':
        if de_queue: print(0)
        else: print(1)
    
    elif temp[0] == 'front':
        if de_queue: print(de_queue[0])
        else: print(-1)
    
    elif temp[0] == 'back':
        if de_queue: print(de_queue[-1])
        else: print(-1)