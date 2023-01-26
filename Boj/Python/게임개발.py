#Baekjoon
from collections import deque, defaultdict
import sys, heapq
input = sys.stdin.readline

n = int(input())

degree = [0]*n
costs = [0]*n
graph = defaultdict(list)
for i in range(n):
    temp = list(map(int, input().split()))
    costs[i] = temp[0]
    for j in range(1, len(temp)-1):
        degree[i] += 1
        graph[temp[j]-1].append(i)

h = []
answers = [0]*n

for d in range(n):
    if degree[d] == 0:
        heapq.heappush(h, (costs[d], d))
        answers[d] = costs[d]

while h:
    answer, now= heapq.heappop(h)
    for next in graph[now]:
        degree[next] -= 1
        if degree[next] == 0:
            heapq.heappush(h, (answer+costs[next], next))
            answers[next] = answer+costs[next]

for a in answers:
    print(a)