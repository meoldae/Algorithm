#Baekjoon 1002
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = pow(((x2-x1)**2) + ((y2-y1)**2), (1.0/2.0))
    
    if d == 0 and r1 == r2:
        print(-1)
    elif r1 + r2 == d or abs(r1 - r2) == d:
        print(1)
    elif abs(r1-r2) < d < r1 + r2:
        print(2)
    else:
        print(0)