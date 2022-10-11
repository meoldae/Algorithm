#Baekjoon 10610
import sys
input = sys.stdin.readline

N = list(map(int, list(input().rstrip())))
lst = sorted(N, reverse=True)

answer = 0
if 0 not in lst:	
    print(-1)
else:
    for i in lst:
        answer += i
    if answer % 3 != 0 :
        print(-1)
    else:
        for j in lst:
            print(j,end="")