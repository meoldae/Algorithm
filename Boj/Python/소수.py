#Baekjoon 2581
import sys
input = sys.stdin.readline

m = int(input())
n = int(input())

answer = []

for i in range(m, n+1):
    if i == 1: continue
    elif i == 2: answer.append(i)
    
    else:
        for j in range(2, i):
            if i % j == 0:
                break
        else:
            answer.append(i)

print(answer)

if len(answer) == 0:
    print(-1)
else:
    print(sum(answer))
    print(answer[0])