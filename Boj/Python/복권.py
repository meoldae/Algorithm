import sys
from itertools import combinations, product

n, m, k = map(int, input().split())

nums = [i for i in range(1, n+1)]

my_choice = list(map(list, combinations(nums, m)))

total = list(map(list, product(my_choice, repeat=2)))
cnt = 0
for i in range(len(total)):
    count = 0
    for j in range(len(total[i][0])):
        if total[i][0][j] in total[i][1]:
            count += 1
            if count >= k:
                cnt += 1
                break

print(cnt/len(total))