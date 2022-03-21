import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
answer = defaultdict(int)

for i in nums:
    answer[i] += 1

m = int(input())
dst = list(map(int, input().split()))

for i in dst:
    print(answer[i], end=" ")