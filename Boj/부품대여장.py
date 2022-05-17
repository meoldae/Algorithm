#Baekjoon 21942
import sys
from datetime import datetime
from collections import defaultdict
input = sys.stdin.readline

N, L, F = input().split()
N = int(N)
F = int(F)

temp = datetime.strptime(L, "%j/%H:%M")
origin = datetime(1900, 1, 1)
due = temp - origin

infos = defaultdict(dict)

for _ in range(N):
    day, time, device, id = input().split()
    info = datetime.strptime(day+time, "%Y-%")