#Baekjoon 11509
import sys
input = sys.stdin.readline

n = int(input())
h = list(map(int, input().split()))
height = [0] * 1000001
    
for i in range(n):
    if height[h[i]]:
        height[h[i]-1] += 1
        height[h[i]] -= 1
    else:
        height[h[i]-1] += 1

print(sum(height))