#Baekjoon 3986
import sys
input = sys.stdin.readline

n = int(input())
answer = 0
for _ in range(n):
    stack = []
    s = input().rstrip()
    for w in s:
        if not stack:
            stack.append(w)
        else:
            if w == stack[-1]:
                stack.pop()
            else:
                stack.append(w)        
    else:
        if len(stack) == 0:
            answer += 1
print(answer)