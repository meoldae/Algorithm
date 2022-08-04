#Baekjoon 11723
import sys
input = sys.stdin.readline

s = [0 for _ in range(21)]
m = int(input())

for _ in range(m):
    operation = input().split()
    
    if operation[0] == 'add':
        s[int(operation[1])] = 1
        
    elif operation[0] == 'remove':
        s[int(operation[1])] = 0
    
    elif operation[0] == 'check':
        if s[int(operation[1])] == 1:
            print(1)
        else:
            print(0)
  
    elif operation[0] == 'toggle':
        if s[int(operation[1])] == 1:
            s[int(operation[1])] = 0
        else:
            s[int(operation[1])] = 1
        
    elif operation[0] == 'all':
        s = [1 for _ in range(21)]
    
    elif operation[0] == 'empty':
        s = [0 for _ in range(21)]