#Baekjoon 11279
import sys
import heapq
input = sys.stdin.readline

h = []

n = int(input())
for _ in range(n):
    temp = int(input())
    if temp != 0:
        heapq.heappush(h, -temp)
    elif temp == 0:
        if len(h) == 0:
            print(0)
        else:
            print(-1*(heapq.heappop(h)))