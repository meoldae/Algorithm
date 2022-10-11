#Baekjoon 2845
import sys
input = sys.stdin.readline

l, p = map(int, input().split())
nums = list(map(int, input().split()))

for num in nums:
    print(num-(l*p), end=" ")