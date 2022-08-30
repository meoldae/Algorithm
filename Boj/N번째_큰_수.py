#Baekjoon 2075
import sys, heapq
input = sys.stdin.readline

n = int(input())
h = []

for _ in range(n):
    tmp = list(map(int, input().split()))
    for num in tmp:
        heapq.heappush(h, num)
        if len(h) > n:
            heapq.heappop(h)

print(h[0])