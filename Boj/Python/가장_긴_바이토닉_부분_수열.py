#Baekjoon 11054
import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

dp = [[1, 1] for _ in range(n) ]

for i in range(n):
    for j in range(i):
        if nums[i] > nums[j]:
            dp[i][0] = max(dp[i][0], dp[j][0]+1)
            
for i in range(n-1, -1, -1):
    for j in range(n-1, i-1, -1):
        if nums[i] > nums[j]:
            dp[i][1] = max(dp[i][1], dp[j][1]+1)

answer = 0
for i in range(n):
    answer = max(answer, sum(dp[i]) - 1)
    
print(answer)