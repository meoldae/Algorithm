# Baekjoon 1074
import sys
input = sys.stdin.readline

N, r, c = map(int, input().split())

answer = 0

while N > 0:
    s_square = (2**N)//2
    
    if s_square > r and s_square <= c: # 1사분면
        answer += s_square ** 2     # 2사분면 탐색값 합산
        c -= s_square               # 열 옮겨서 2 사분면으로 옮김
        
    elif s_square > r and s_square > c: # 2사분면
        pass
    
    elif s_square <= r and s_square > c: #3사분면
        answer += (s_square ** 2) * 2 # 1, 2 사분면 탐색값 합산
        r -= s_square                 # 3사분면이므로 행만 변경
        
    elif s_square <= r and s_square <= c: #4사분면
        answer += (s_square ** 2) * 3   # 1, 2, 3 사분면 탐색값 합산
        r -= s_square
        c -= s_square                   # 행, 열 모두 변경
    N -= 1

print(answer)