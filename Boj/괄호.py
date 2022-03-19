import sys
input = sys.stdin.readline
n = int(input())

for i in range(n):
    str = input().rstrip()
    stack = []
    
    for word in str:
        if word == '(':
            stack.append('(')
        else:
            if stack == [] or stack[-1] == ')':
                print('NO')
                break
            else:
                stack.pop()

    else:
        if stack != []:
            print('NO')
        else:
            print('YES')