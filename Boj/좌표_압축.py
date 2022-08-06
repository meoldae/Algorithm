#Baekjoon 18870
import sys
input = sys.stdin.readline

n = int(input())
origin_nums = list(map(int, input().split()))

sorted_nums = set(origin_nums)
sorted_nums = sorted(list(sorted_nums))
dict_nums = dict()
for i in range(len(sorted_nums)):
    dict_nums[sorted_nums[i]] = i
    
for num in origin_nums:
    print(dict_nums[num], end = " ")