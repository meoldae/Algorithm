#Baekjoon 11286
import sys, heapq
input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    temp = int(input())
    if temp != 0:
        heapq.heappush(heap, [abs(temp), temp]) 
    else:
        if len(heap) == 0:
            print(0)
        else:
            a = heapq.heappop(heap)
            print(a[1])
        