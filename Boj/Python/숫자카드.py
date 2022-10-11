#Baekjoon 10815
import sys
input = sys.stdin.readline

n = int(input())
sang = list(map(int, input().split()))
answer = dict()
for i in sang:
    answer[i] = 0

m = int(input())
cards = list(map(int, input().split()))

for c in cards:
    if c in answer:
        print(1, end=" ")
    else:
        print(0, end=" ")