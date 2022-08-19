#Baekjoon 17219 
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
pwList = dict()
for _ in range(n):
    domain, pw = input().rstrip().split()
    pwList[domain] = pw

for _ in range(m):
    domain = input().rstrip()
    print(pwList[domain])