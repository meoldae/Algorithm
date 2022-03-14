import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
nums = []
nums_count = defaultdict(int)

for i in range(n):
    temp = int(input())
    nums.append(temp)
    nums_count[temp] += 1
    
print(round(sum(nums)/n))

nums.sort()
print(nums[n//2])

count_list = [k for k, v in nums_count.items() if v == max(nums_count.values())]
count_list.sort()
if len(count_list) > 1:
    print(count_list[1])
else:
    print(count_list[0])

print(abs(nums[0]-nums[-1]))