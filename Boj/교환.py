#Baekjoon 1039
import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
l = len(str(n))

answer = 0
queue = deque()
queue.append([n, 0])
visited = [[0]*1000001 for _ in range(k+1)]
visited[0][n] = 1

while queue:
    val, count = queue.popleft()
    
    if count == k:
        answer = max(answer, val)
        continue
    
    forChange = list(str(val))
    for i in range(l-1):
        for j in range(i+1, l):
            if i==0 and forChange[j] == '0':
                continue
        
            forChange[i], forChange[j] = forChange[j], forChange[i]
            changed = int(''.join(forChange))
            
            if visited[count+1][changed] == 0:
                queue.append([changed, count+1])
                visited[count+1][changed] = 1
            forChange[i], forChange[j] = forChange[j], forChange[i]    
                    
if answer == 0:
    print(-1)
else:
    print(answer)