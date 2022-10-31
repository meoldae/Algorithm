#Baekjoon 1484
import sys
input = sys.stdin.readline

g = int(input())

current = 2
expected = 1
answer = []

while current < 100000:
    if current**2 - expected**2 == g:
        answer.append(current)
    
    if current**2 - expected**2 < g:
        current += 1
    else:
        expected += 1

if answer:
    for a in answer:
        print(a)
else:
    print(-1)