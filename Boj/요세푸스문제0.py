from collections import deque
n, k = map(int, input().split())

answer = []
queue = deque([i for i in range(1, n+1)])
count = 1

while queue:
    temp = queue.popleft()    
    if count % k == 0:
        answer.append(str(temp))
    else:
        queue.append(temp)
    count += 1

print("<%s>" %(", ".join(answer)))