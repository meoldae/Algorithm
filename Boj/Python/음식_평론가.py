#Baekjoon 1188
import sys
input = sys.stdin.readline

count = 0
n, m = map(int, input().split())

while True:
    if n % m == 0:
        break

    if n > m:
        n -= m
    else:
        m -= n
        count += n

print(count)