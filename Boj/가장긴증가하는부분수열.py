#Baekjoon 11053
import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

answer = [1] * n

for i in range(1, n):
    for j in range(i):
        if a[i] > a[j]:
            answer[i] = max(answer[i], answer[j]+1)

print(answer)