#Baekjoon 7662
import sys, heapq
from collections import defaultdict
input = sys.stdin.readline

def solution():
    n = int(input())
    max_h = []
    min_h = []
    nums = defaultdict(list)
    for _ in range(n):
        command, num = input().rstrip().split()
            
        if command == 'I':
            heapq.heappush(min_h, int(num))
            heapq.heappush(max_h, (int(num)*-1, int(num)))
            nums[int(num)].append(1)
        else:
            if num == '1':
                while max_h and not nums[max_h[0][1]]:
                    heapq.heappop(max_h)
                        
                if max_h:
                    val = heapq.heappop(max_h)[1] 
                    nums[val].pop()
                
            elif num == '-1':
                while min_h and not nums[min_h[0]]:
                    heapq.heappop(min_h)
                    
                if min_h:
                    val = heapq.heappop(min_h)
                    nums[val].pop()

    check = True
    for value in nums.values():
        if value:
            check = False
    
    if check:
        print('EMPTY')
    else:
        while max_h and not nums[max_h[0][1]]:
            heapq.heappop(max_h)
        print(heapq.heappop(max_h)[1], end=" ")
        
        while min_h and not nums[min_h[0]]:
            heapq.heappop(min_h)
        print(heapq.heappop(min_h))
        
t = int(input())
for _ in range(t):
    solution()