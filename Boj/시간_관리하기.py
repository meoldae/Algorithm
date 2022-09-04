#Baekjoon 6068
import sys
input = sys.stdin.readline

def pf(time):
    for t, s in tasks:
        time += t
        if time > s:
            return False
    return True

n = int(input())
tasks = []

for _ in range(n):
    t, s = map(int, input().split())
    tasks.append([t, s])

tasks.sort(key=lambda x: (x[1], x[0]))

time = 0
while True:
    if not pf(time):
        if time == 0:
            print(-1)
            break
        else:
            print(time-1)
            break
    else:
        time += 1