#Baekjoon 1932
import sys
input = sys.stdin.readline

n = int(input())

triangle = []
for _ in range(n):
    triangle.append(list(map(int, input().split())))

for i in range(1, n):
    temp = [0]*len(triangle[i])
    
    for j in range(1, len(triangle[i])):
        temp[j-1] = max(temp[j-1], triangle[i-1][j-1]+triangle[i][j-1])
        temp[j] = max(temp[j], triangle[i-1][j-1]+triangle[i][j])
    triangle[i] = temp

print(max(triangle[n-1]))