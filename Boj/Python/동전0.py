#Baekjoon 11047
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

moneys = []
for _ in range(n):
    money = int(input())
    moneys.append(money)
    
count = 0
for money in reversed(moneys):
    if k >= money:
        cnt = k//money
        k -= money * cnt
        count += cnt
        
    if k <= 0:
        break

print(count)