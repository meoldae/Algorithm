#Baekjoon 2225
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

dp = [[0]*n for i in range(k)]
print(dp)
