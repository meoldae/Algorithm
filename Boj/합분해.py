#Baekjoon 2225
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

dp = [[0]*(n) for _ in range(k)]

for i in range(n):
    dp[0][i] = 1
    dp[1][i] = i+2

for i in range(k):
    dp[i][0] = i+1
  
for a in range(2, k):
    for b in range(1, n):
        dp[a][b] = dp[a-1][b] + dp[a][b-1]

print(dp[k-1][n-1]%1000000000)