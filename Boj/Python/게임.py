#Baekjoon 1072
import sys
input = sys.stdin.readline

x, y = map(int, input().split())
z = (y*100) // x

left = 1
right = x

answer = 0
while left <= right:
    mid = (left+right)//2
    temp = (y + mid)*100 // (x+mid) 
    
    if temp <= z:
        left = mid + 1
        
    else:
        right = mid - 1
        answer = mid
        
if answer == 0:
    print(-1)
else:
    print(answer)