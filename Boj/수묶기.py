#Baekjoon 1744
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
nums = []

for _ in range(n):
    nums.append(int(input()))
    
queue = deque()
queue.extend(sorted(nums, reverse=True))

answer = 0
while queue:    
    if len(queue) >= 2: 
        if queue[1] > 0:
            if queue[0] == queue[1] == 1:
                answer += queue.popleft()+queue.popleft()
            else:
                answer += (queue.popleft()*queue.popleft())
        elif queue[1] == 0:
            answer += queue.popleft()
        else:
            if queue[0] == 0:
                answer += (queue.popleft()*queue.popleft())
            else:
                answer += (queue.popleft()+queue.popleft())
    else:
        answer += queue.popleft()
    
print(answer)