#Baekjoon 1715
import sys
import heapq
input = sys.stdin.readline

n = int(input())
p_q = []
for _ in range(n):
    heapq.heappush(p_q, int(input()))

answer = 0
while p_q:
    a = heapq.heappop(p_q)
    if p_q:
        b = heapq.heappop(p_q)
        answer += (a+b)
        heapq.heappush(p_q, a+b)

print(answer)