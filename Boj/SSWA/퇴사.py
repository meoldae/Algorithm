#Baekjoon 14501
#삼성 SW 역량테스트 기출 문제
import sys
input = sys.stdin.readline

n = int(input())
t = [0]
p = [0]
for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)
    
dp = [0]*(n+1)

for i in range(n+1):
    if i+t[i]-1 < len(dp):
        dp[i +t[i]-1] = max(dp[i+t[i]-1], dp[i-1] + p[i])
    dp[i] = max(dp[i], dp[i-1])

print(max(dp))