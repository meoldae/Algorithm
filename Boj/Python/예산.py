#Baekjoon 2512
import sys
input = sys.stdin.readline

n = int(input())
budget = list(map(int, input().split()))
total = int(input())

left = 1
right = max(budget)

while left <= right:
    mid = (left+right)//2
    
    sum = 0
    
    for depart in budget:
        if depart <= mid:
            sum += depart
        else:
            sum += mid
    
    if sum <= total:
        left = mid+1
        
    else:
        right = mid-1
            
print(right)