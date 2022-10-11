#Baekjoon 9084
import sys
input = sys.stdin.readline

def dp():
    n = int(input())
    moneys = list(map(int, input().split()))
    dst = int(input())
    
    dp = [0]*(dst+1)
    dp[0] = 1
    
    for money in moneys:
        for i in range(dst+1):
            if i >= money:
                dp[i] += dp[i-money]
            
    print(dp[dst])
    return

t = int(input())

for _ in range(t):
    dp()