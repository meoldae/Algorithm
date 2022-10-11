dst = int(input())
n = int(input())

if n != 0:
    broken_num = list(input().split())
else:
    broken_num = list()

answer = abs(100 - dst)

for nums in range(1000001):
    for num in str(nums):
        if num in broken_num:
            break
    else:
        answer = min(answer, len(str(nums)) + abs(int(nums)-int(dst)))

print(answer)

