#Baekjoon 1744
import sys
input = sys.stdin.readline

n = int(input())
pos = []
neg = []

answer = 0
for _ in range(n):
    temp = int(input())
    if temp == 1:
        answer += 1
    elif temp > 0:
        pos.append(temp)
    else:
        neg.append(temp)
    
pos.sort()
neg.sort(reverse=True)

while pos:
    if len(pos) == 1:
        answer += pos.pop()
    else:
        answer += pos.pop()*pos.pop()

while neg:
    if len(neg) == 1:
        answer += neg.pop()
    else:
        answer += neg.pop()*neg.pop()

print(answer)