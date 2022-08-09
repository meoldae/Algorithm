#Baekjoon 2579
import sys
input = sys.stdin.readline

n = int(input())

stairs = []
for _ in range(n):
    stairs.append(int(input()))

dp = [0] * (n+1)

if n == 1:
    print(stairs[0])
else:
    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1]
    if n > 2:
        dp[2] = max(stairs[1]+stairs[2], stairs[0]+stairs[2]) # 2 3 or 1 3
    
    for i in range(3, n):
        dp[i] = max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i]) # Last-1 O or Last-1 X
    
    print(dp[n-1])