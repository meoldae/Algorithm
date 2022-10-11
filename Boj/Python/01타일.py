#Baekjoon 1904
import sys
input = sys.stdin.readline

n = int(input())
dp = [0]*10000000
dp[0] = 1
dp[1] = 2

for i in range(2, n):
    dp[i] = (dp[i-2] + dp[i-1]) % 15746

print(dp[n-1])

# 1  1
# 2  00 11
# 3  111 001 100 
# 5  0011 1001 1100 1111 0000 
# 8  00111 10011 11001 11100 11111 10000 00001 00100