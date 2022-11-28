#Baekjoon 1629
import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())
num = a % c
a %= c
while b:
    num *= a
    num %= c
    b -= 1

print(num)