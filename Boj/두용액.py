#Baekjoon 2470
import sys
input = sys.stdin.readline

n = int(input())

nums = sorted(list(map(int, input().split())))

left = 0
right = n-1
val = 2e9
answer = []

while left < right:
    middle = nums[left] + nums[right]
    
    if val > abs(middle):
        val = abs(middle)
        answer = [nums[left], nums[right]]        
    
    if middle > 0:
        right -= 1
    else:
        left += 1

print(answer[0], answer[1])