import sys
input = sys.stdin.readline

while True:
    str = input().rstrip()
    
    if str == '.': break
    
    stack = []
    
    for i in str:
        if i == '(' or i == '[':
            stack.append(i)
            
        else:
            if i == ')' :
                if stack == [] or stack[-1] != '(':
                    print('no')
                    break
                elif stack[-1] == '(':
                    stack.pop()
                    
        
            elif i == ']':
                if stack == [] or stack[-1] != '[':
                    print('no')
                    break
                elif stack[-1] =='[':
                    stack.pop()
                        
    else:
        if len(stack) >= 1:
            print('no')
        else:
            print('yes')