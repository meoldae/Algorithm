import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

h = deque()

for _ in range(n):
    val = list(input().split())
    
    if val[0] == 'push':
        h.append(int(val[1]))
    elif val[0] == 'pop':
        if len(h) == 0:
            print(-1)
        else:
            print(h.popleft())
    elif val[0] == 'size':
        print(len(h))
    elif val[0] == 'empty':
        if len(h) == 0:
            print(1)
        else:
            print(0)
    elif val[0] == 'front':
        if len(h) == 0:
            print(-1)
        else:
            print(h[0])
    elif val[0] == 'back':
        if len(h) == 0:
            print(-1)
        else:
            print(h[len(h)-1])