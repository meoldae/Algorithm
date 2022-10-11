#Baekjoon 1620
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
d = dict()
d2 = dict()

for i in range(n):
    temp = input().rstrip()
    d[i+1] = temp
    d2[temp] = [i+1]
    
for _ in range(m):
    quiz = input().rstrip()
    
    if 48 <= ord(quiz[0]) <= 57:
        print(d[int(quiz)])
    
    else:
        print(d2[quiz][0])