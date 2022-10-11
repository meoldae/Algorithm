#Baekjoon 1463
import sys
input = sys.stdin.readline

x = int(input())

dp = [0] * (x+1)

for i in range(2, x+1):
    
    # 2, 3 모두 나누기 불가
    dp[i] = dp[i-1]+1
    
    # 2로 나눌 수 있을 때
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2]+1) # 기존값 vs 2로 나누기 직전 값 + 1 
    
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3]+1) # 기존값 vs 3으로 나누기 직전 값 + 1

print(dp[x])