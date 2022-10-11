nums = list(map(int, input().split()))

nums.sort()

for i in range(len(nums)):
    print(nums[i], end=" ")