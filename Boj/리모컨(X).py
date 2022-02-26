from itertools import product

dst = input()
dst_l = len(dst)
dst = int(dst)
answer = abs(100 - dst)
n = int(input())
nums = [i for i in range(10)]
if n != 0:
    broken_num = list(map(int, input().split()))
    nums = [num for num in nums if num not in broken_num]

# dst보다 작은 것 중 가장 큰 수 or dst보다 큰 것 중 가장 작은 수 
# 각각의 수와 dst와의 차이가 작은것으로 결정후 차이 계산

num_list = list(map(list, list(product(nums, repeat=dst_l))))

for i in range(len(num_list)):
    num_list[i] = ''.join(map(str, num_list[i]))

num_list = list(map(int, num_list))
num_list.append(dst)
num_list.sort()
idx = num_list.index(dst)
if len(num_list) >= 3:
    diff = min(abs(num_list[idx-1]-dst), abs(num_list[idx+1]-dst))
else:
    diff = 100000
answer = min(answer, diff+dst_l)
print(answer)

