#Baekjoon 5525
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().rstrip()

answer = 0
repeat = 0
idx = 1
while idx < m-1:
    if s[idx-1:idx+2] == 'IOI':
        repeat += 1
        if repeat == n: # Pn일 경우
            answer += 1
            repeat -= 1 # 1회 카운트 했으므로 다음 겹친부분부터 판단하기 위함
        idx += 1 # O 넘기고 다음 I 확인을 위해 Index 하나 더 더함
    else:
        repeat = 0  # 패턴 안맞으면 반복횟수 초기화
    idx += 1
        
print(answer)