#Baekjoon 1011
import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    
    count = 0
    dis = 1
    
    while x < y:
        count += 1
        x += dis
        if count % 2 == 0:
            dis += 1
    print(count)