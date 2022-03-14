import sys
from collections import deque
input = sys.stdin.readline

t_c = int(input())
for i in range(t_c):
    n, dst = map(int, input().split())
    priorities = list(map(int, input().split()))
    queue = deque(enumerate(priorities))
    priorities.sort(reverse=True)
    count = 0
        
    while queue:
        target, priority = queue.popleft()
        
        if target == dst and priority == priorities[0]:
            count += 1
            print(count)
            break
        
        elif target != dst and priority == priorities[0]:
           del priorities[0]
           count += 1
        
        else:
            queue.append((target, priority))