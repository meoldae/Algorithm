#Baekjoon 2493
import sys
input = sys.stdin.readline

n = int(input())
towers = list(map(int, input().split()))
stack = []
answer = []
for i in range(n):
    if len(stack) == 0:
        stack.append([towers[i], i])
        answer.append(0)
    else:
        while stack:
            if stack[-1][0] < towers[i]:
                stack.pop()
                if len(stack) == 0:
                    answer.append(0)
            else:
                answer.append(stack[-1][1]+1)
                break
        stack.append([towers[i], i])        
for num in answer:
    print(num, end=" ")