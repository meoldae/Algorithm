#Baekjoon 11478
import sys
input = sys.stdin.readline

s = input().rstrip()

answer = set()

for i in range(len(s)+1):
    for j in range(i+1, len(s)+1):
        answer.add(s[i:j])

print(len(answer))