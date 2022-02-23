import sys
input = sys.stdin.readline

n, k = map(int, input().split())

dp = [0] * (k+1)
dp[0] = 1

moneys = []
for i in range(n):
    moneys.append(int(input()))
    
print(moneys)
moneys.sort()

for coin in moneys:
    for i in range(coin, k+1):
        dp[i] += dp[i-coin]
        
print(dp[-1])

