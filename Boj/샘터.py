import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
fountains = list(map(int, input().split()))
visited = dict()

queue = deque()
for fountain in fountains:
    queue.append((fountain, 1))
    visited[fountain] = 1

d_loc = [-1, 1]

house_cnt = 0
answer = 0
while queue:
    loc, distance = queue.popleft()
    
    if k == 0:
        break
    
    for direction in d_loc:
        n_loc = loc + direction
        
        if n_loc not in visited and k > 0:
            visited[n_loc] = 1
            k -= 1
            answer += distance
            queue.append((n_loc, distance+1))
            
print(answer)