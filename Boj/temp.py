import sys
input = sys.stdin.readline

s = input().rstrip()

arr = []

for i in range(len(s)):
    arr.append(s[i:len(s)])
    
arr.sort()
for w in arr:
    print(w)