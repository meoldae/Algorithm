#SWEA
# import sys
# input = sys.stdin.readline
from itertools import combinations

t = int(input())

for tc in range(1, t+1):
    n, m = map(int, input().split())
    alpha = ['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z']
    com = list(combinations(alpha, m))
    
    lst = []
    for _ in range(n):
        line = set(sorted(list(input().rstrip())))
        if len(line) <= m:
            lst.append(line)
    
    maxVal = 0

    for c in com:
        answer = 0
        for l in lst:
            if len(set(c) & l) >= min(len(set(c)), len(l)):
                answer += 1
        maxVal = max(maxVal, answer)
    
    print("#{} {}".format(tc, maxVal))