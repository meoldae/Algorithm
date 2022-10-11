#Baekjoon 14425
import sys
input = sys.stdin.readline
n, m = map(int, input().split())

s = []
for _ in range(n):
    s.append(input().rstrip())

answer = 0
for _ in range(m):
    temp = input().rstrip()
    if temp in s:
        answer += 1

print(answer)