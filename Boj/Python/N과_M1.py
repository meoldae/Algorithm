#Baekjoon 15649
import sys
input = sys.stdin.readline

def backTracking(nums:list):
    global m, n

    if len(nums) == m:
        print(*nums)
        return
    
    for i in range(1, n+1):
        if i not in nums:
            nums.append(i)
            backTracking(nums)
            nums.remove(i)
    return

n, m = map(int, input().split())

for i in range(1, n+1):
    nums = []
    nums.append(i)
    backTracking(nums)
    nums.remove(i)