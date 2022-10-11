import sys
input = sys.stdin.readline

t = int(input())

def solution(t):
    for _ in range(t):
        h, w, n = map(int, input().split())
        if n%h == 0:
            room = h*100 + ((n//h))
        else:
            room = ((n//h)+1) + (n%h)*100
        print(room)
solution(t)