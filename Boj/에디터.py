#Baekjoon 1406
import sys
input = sys.stdin.readline

s = list(input().rstrip())
s_2 = list()

n = int(input())
cursor = len(s)

for _ in range(n):
    temp = list(input().rstrip().split())
    
    if temp[0] == 'L':
        if s:
            s_2.append(s.pop())
        
    elif temp[0] == 'D':
        if s_2:
            s.append(s_2.pop())
    
    elif temp[0] == 'B':
        if s:
            s.pop()
    
    elif temp[0] == 'P':
        s.append(temp[1])
        
print(''.join(s+s_2[::-1]))