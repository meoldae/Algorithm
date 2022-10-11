#Baekjoon 5014
import sys
from collections import deque
input = sys.stdin.readline

def solution():
    floor, src, dst, up, down = map(int, input().split())

    if src == dst:
        print(0)
        return

    queue = deque()

    queue.append([src, 0])
    visited = [1e9]*(floor+1)
    visited[src] = 1
    
    while queue:
        now, count = queue.popleft()
        
        for d in [up, -down]:
            next = now+d
            if next <= 0 or next > floor:
                continue
            
            if next == dst:
                print(count+1)
                return
            # print(visited)
            if visited[next] > count+1:
                queue.append([next, count+1])
                visited[next] = count+1
    else:
        print('use the stairs')
    
    return

solution()