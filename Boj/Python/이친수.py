#Baekjoon 2193
import sys
input = sys.stdin.readline

n = int(input())

dp = [1, 1]
for i in range(2, 90):
    dp.append(dp[i-1]+dp[i-2])
    
print(dp[n-1])

# 1
# 10
# 100 101 
# 1000 1010 1001 
# 10000 10001 10101 10100 10010