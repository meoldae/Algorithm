import sys
input = sys.stdin.readline

n = int(input())
stack = []
for i in range(n):
    temp = list(input().split())
    
    if temp[0] == 'push':
        stack.append(int(temp[1]))
    
    elif temp[0] == 'pop':
        if stack: print(stack.pop())
        else: print(-1)
    
    elif temp[0] == 'size':
        print(len(stack))
        
    elif temp[0] == 'empty':
        if stack: print(0)
        else: print(1)
    
    elif temp[0] == 'top':
        if stack: print(stack[-1])
        else: print(-1)