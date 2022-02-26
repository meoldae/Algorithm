import sys
input = sys.stdin.readline

n, k = map(int, input().split())

dp = [10001] * (k+1)
dp[0] = 0

moneys = []
for i in range(n):
    moneys.append(int(input()))

moneys.sort()

for i in range(n):
    for j in range(moneys[i], k+1):
        dp[j] = min(dp[j], dp[j-moneys[i]]+1)
        
        
if dp[-1] == 10001:
    print(-1)
else:
    print(dp[-1])