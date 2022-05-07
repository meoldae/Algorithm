#Baekjoon 21944
import sys
import heapq
from collections import defaultdict
input = sys.stdin.readline

n = int(input())

# 알고리즘별로
rec1_pos = defaultdict(list)
rec1_neg = defaultdict(list)

# 알고리즘 상관 없이
rec2_pos = list()
rec2_neg = list()

for _ in range(n):
    p, l, g = map(int, input().split())
    
    heapq.heappush(rec1_pos[g], [-l, -p])
    heapq.heappush(rec1_neg[g], [l, p])
    heapq.heappush(rec2_pos, [-l, -p])
    heapq.heappush(rec2_neg, [l, p])

n = int(input())

for _ in range(n):
    temp = list(map(int, input().split()))
    
    