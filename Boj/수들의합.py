#Baekjoon 1789
import sys
input = sys.stdin.readline

n = int(input())

num = 1
answer = 0

while n > 0:
    n -= num
    
    if n >= 0:
        answer += 1
        num += 1
    else:
        print(answer)