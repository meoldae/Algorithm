#Baekjoon 9935
import sys
input = sys.stdin.readline

s = input().rstrip()
w = input().rstrip()

while w in s:    
    s = s.replace(str(w), "")

if s:
    print(s)
else:
    print("FRULA")