from collections import deque
n = int(input())

queue = deque([i for i in range(1, n+1)])

while True:
    x = queue.popleft()
    if len(queue) == 0:
        print(x)
        break
    x = queue.popleft()
    queue.append(x)