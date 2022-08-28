#Baekjoon 10972
import sys
input = sys.stdin.readline

def solution():
    n = int(input())
    nums = list(map(int, input().split()))

    for i in reversed(range(1, n)):
        if nums[i] > nums[i-1]:
            check = i-1
            break
    else:
        print(-1)
        return
    
    for i in reversed(range(1, n)):
        if nums[i] > nums[check]:
            nums[check], nums[i] = nums[i], nums[check]
            nums = nums[:check+1] + sorted(nums[check+1:])
            print(*nums)
            return

solution()