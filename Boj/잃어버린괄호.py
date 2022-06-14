#Baekjoon 1541
import sys
input = sys.stdin.readline

lst = list(input().rstrip().split('-'))

first = list(map(int, lst[0].split('+')))

answer = sum(first)


for i in range(1, len(lst)):
    temp = list(map(int, lst[i].split('+')))
    answer -= sum(temp)

print(answer)