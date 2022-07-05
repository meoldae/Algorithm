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
        input()
        temp = []        
    lst = deque(temp)

    for c in command:
        if c == 'R':
            lst.reverse()
        
        elif c == 'D':
            if len(lst) == 0:
                print('error')
                break
            else:
                lst.popleft()
    if len(lst) != 0:
        print(list(map(int, lst)))