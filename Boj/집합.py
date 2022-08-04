#Baekjoon 11723
import sys
input = sys.stdin.readline

s = dict()
all_s = dict()
for i in range(1, 21):
    all_s[i] = 1
m = int(input())

for _ in range(m):
    operation = input().split()
    
    if operation[0] == 'add':
        s[int(operation[1])] = 1
        
    elif operation[0] == 'remove':
        s.pop(int(operation[1]))
    
    elif operation[0] == 'check':
        if int(operation[1]) in s:
            print(1)
        else:
            print(0)
    
    elif operation[0] == 'toggle':
        if int(operation[1]) in s:
            s.pop(int(operation[1]))
        else:
            s[int(operation[1])] = 1
    
    elif operation[0] == 'all':
        s = all_s
    
    elif operation[0] == 'open':
        s = dict()