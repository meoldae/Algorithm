import sys
n = int(input())
for _ in range(n):
    temp = sys.stdin.readline().rstrip()
    print(temp[0]+temp[-1])