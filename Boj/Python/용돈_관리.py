#Baekjoon 6236
import sys
input = sys.stdin.readline

def check(k):
    count = 1
    money = k
    
    for i in range(n):
        if money < plan[i]:
            money = k
            count += 1
        else:
            money -= plan[i]
    if count > m :
        return True
    
    return False

n, m = map(int, input().split())

plan = []
for _ in range(n):
    plan.append(int(input()))

left = min(plan)
right = sum(plan)
answer = 0

while left <= right:
    mid = (left+right)//2
    money = mid
    
    count = 1
    
    for i in range(n):
        if money < plan[i]:
            money = mid
            count += 1
        money -= plan[i]

    if count > m or mid< max(plan):
        left = mid + 1
    else:
        right = mid - 1
        answer = mid
            
print(answer)