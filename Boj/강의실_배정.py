#Baekjooin 11000
import sys, heapq
input = sys.stdin.readline

n = int(input())
classes = []
h = []
for _ in range(n):
    classes.append(list(map(int, input().split())))
    
classes.sort()
heapq.heappush(h, classes[0][1])

for i in range(1, n):
    if h[0] > classes[i][0]: # 끝나는 시간보다 작으면 강의실 이용 불가. 따라서 강의실 + 1
        heapq.heappush(h, classes[i][1])
    else:   # 끝나는 시간보다 늦거나 같으면 강의실 정보 업데이트
        heapq.heappop(h) 
        heapq.heappush(h, classes[i][1])

print(len(h))