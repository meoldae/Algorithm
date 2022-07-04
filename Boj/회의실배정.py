#Baekjoon 1931
import sys
input = sys.stdin.readline

n = int(input())
meetings = []
for _ in range(n):
    temp = list(map(int, input().split()))
    
    meetings.append(temp)
    
meetings.sort(key= lambda x : (x[1], x[0]))

count = 1
time = meetings[0][1]
meetings = meetings[1::]

for meet in meetings:
    if meet[0] >= time:
          count += 1
          time = meet[1]  

print(count)