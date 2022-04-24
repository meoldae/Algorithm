#Baekjoon 11659
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num_lst = list(map(int, input().split()))
sums = [0]
temp = 0
for i in range(len(num_lst)):
    temp += num_lst[i]
    sums.append(temp)

for _ in range(m):
    left, right = map(int, input().split())
    print(sums[right]-sums[left-1])