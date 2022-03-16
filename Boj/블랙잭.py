import sys
input = sys.stdin.readline

from itertools import combinations

n, m = map(int, input().split())

cards = list(map(int, input().split()))

answer = list(combinations(cards, 3))
answer = list(map(sum, map(list, answer)))
answer.sort()

if m in answer:
    print(m)
else:
    for i in range(len(answer)):
        if answer[i] > m:
            print(answer[i-1])
            break
    else:
        print(answer[-1])