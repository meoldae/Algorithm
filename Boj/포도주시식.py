#Baekjoon 2156
import sys
input = sys.stdin.readline

n = int(input())
glasses = []
for _ in range(n):
    glasses.append(int(input()))
    
dp = [0]*(n+1)
dp[0] = glasses[0]

if n > 1:
    dp[1] = glasses[0]+glasses[1]

for i in range(2, n):
    dp[i] = max(dp[i-1], 
                dp[i-2]+glasses[i],
                dp[i-3]+glasses[i-1]+glasses[i])

print(dp[n-1])