#Baekjoon 1931
import sys
input = sys.stdin.readline

n = int(input())
meeting = []
for _ in range(n):
    temp = list(map(int, input().split()))
    
    meeting.append(temp)
    
meeting.sort(key= lambda x : (x[0], (x[1]-x[0])))

print(meeting)
    