#Baekjoon 6064
import sys
input = sys.stdin.readline

def solution(m, n, x, y):
    k = y
    
    while k <= m*n:
        # if k%m == x:
        #     return k
        # 해당 식은 왜 안되는지 ... 이해불가...
        
        if (k-x)%m == 0:
            return k
        
        
        k += n
    return -1

t = int(input())
for _ in range(t):
    m, n, x, y = map(int, input().split())
    
    print(solution(m, n, x, y))     