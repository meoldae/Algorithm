# Baekjoon 18111 
import sys
from collections import defaultdict
input = sys.stdin.readline

def solution():
    n, m, b = map(int, input().split())

    height = defaultdict(int)
    max_height = 0
    for _ in range(n):
        temp = list(map(int, input().split()))
        for i in temp:
            height[i] += 1
        max_height = max(max_height, max(temp))

    answer = []
    for st in range(max_height, -1, -1):
        time = 0
        blocks = b
        for land in height.keys():
            if land < st:
                time += (st - land) * height[land]
                blocks -= (st - land) * height[land]
            elif land > st:
                time += ((land-st) * 2)*height[land]
                blocks += (land - st)*height[land]
        if blocks >= 0:
            answer.append((time, st))
    answer.sort(key = lambda x:(x[0], -x[1]))
    print(answer[0][0], answer[0][1])

solution()  