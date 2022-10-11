import sys
input = sys.stdin.readline

n = int(input())
stack = []
answer = []
count = 1
for _ in range(n):
    num = int(input())
    while count <= num:
        stack.append(count)
        count += 1
        answer.append(("+"))
    
    if stack[-1] == num:
        stack.pop()
        answer.append(("-"))
    else:
        print("NO")
        break
else:
    for op in answer:
        print(op)