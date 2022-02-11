import sys
input = sys.stdin.readline

N, S = map(int, input().split())
nums = list(map(int, input().split()))
sum = 0
length = 100000

left, right = 0, 0

while True:
    if sum >= S:
        length = min(length, right-left)
        sum -= nums[left]
        left += 1   
        
    elif right == N:
        break
    
    else:
        sum += nums[right]
        right += 1
            
if length == 100000:
    print(0)
else:
    print(length)
        