#Baekjoon 1826
import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n = int(input())
station = defaultdict(list)
for _ in range(n):
    d, v = list(map(int, input().split()))
    station[d] = v
    
# 거리로 우선 정렬     
keys = sorted(station.keys(), reverse=True)

l, p = map(int, input().split())

queue = deque()
queue.append(0)
cnt = 0

while queue:
    now = queue.popleft()   # 좌표
    
    if now - p <= l:    # 도달 가능
        print(cnt)
        
    now += 1
    p -= 1
    
    if p == 0:
        station[]
    
    
    