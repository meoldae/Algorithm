#Baekjoon 1912
import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

answer = 0
temp = 0


for num in lst:
    if num < 0:
        if temp+num < 0:
            temp = 0
        else:
            temp += num
            answer = max(answer, temp)
    else:
        temp += num
        answer = max(answer, temp)
if answer == 0:
    print(max(lst))
else:
    print(answer)    