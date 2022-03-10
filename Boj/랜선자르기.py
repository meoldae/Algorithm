import sys
input = sys.stdin.readline
k, n = map(int, input().split())

cables = []
for i in range(k):
    cables.append(int(input()))
    
left = 1
right = max(cables)

while left <= right:
    middle = (left+right) // 2
    count = 0
    for cable in cables:
        count += cable // middle
    
    if count >= n:
        left = middle + 1
    else:
        right = middle - 1

print(right)