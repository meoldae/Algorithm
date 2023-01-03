#Baekjoon 12852
from collections import deque

N = int(input())
queue = deque()
queue.append([N])
answer = []
visited = [1e9] * (N+1)

while queue:
    arr = queue.popleft()
    x = arr[0]
    if x == 1:
        answer = arr
        break
    if visited[x] > len(arr):
        visited[x] = len(arr)
        if x % 3 == 0:
            queue.append([x//3] + arr)

        if x % 2 == 0:
            queue.append([x//2]+arr)

        queue.append([x-1]+arr)

print(len(answer)-1)
print(*reversed(answer))