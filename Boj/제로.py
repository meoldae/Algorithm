import sys
input = sys.stdin.readline

n = int(input())
nums = []
for i in range(n):
    num = int(input())
    if num == 0:
        nums.pop()
    else:
        nums.append(num)

print(sum(nums))