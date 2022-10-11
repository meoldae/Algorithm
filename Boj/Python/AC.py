#Baekjoon 5430
import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    command = input().rstrip()
    n = int(input())

    if n != 0:
        temp = input().rstrip()[1:-1].split(',')
    else:
        x = input()
        temp = []        
    lst = deque(temp)
    
    r_cnt = 0
    flag = True
    for c in command:
        if c == 'R':
            r_cnt += 1        
        elif c == 'D':
            if len(lst) == 0:
                print('error')
                flag = False
                break
            else:
                if r_cnt % 2 == 0:
                    lst.popleft()
                else:
                    lst.pop()
                    
    if flag:
        if r_cnt % 2 != 0:
            lst.reverse()
        print("["+",".join(lst)+"]")