nums = list(map(int, input().split()))
nums = list(map(lambda x:x*x, nums))
print(sum(nums)%10)