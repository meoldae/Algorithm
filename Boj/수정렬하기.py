import sys
from collections import defaultdict
input = sys.stdin.readline
n = int(input())

answer = defaultdict(int)
for _ in range(n):
    temp = int(input())
    answer[temp] += 1

real_answer = [k for k, v in answer.items()]
real_answer.sort()

for i in real_answer:
    for _ in range(answer[i]):
        print(i)