#Baekjoon 13305
import sys
input = sys.stdin.readline

n = int(input())
e = list(map(int, input().split()))
costs = list(map(int, input().split()))

answer = 0
cost = costs[0]
for i in range(n-1):
    if costs[i] < cost:
        cost = costs[i]
    answer += cost*e[i]
print(answer)