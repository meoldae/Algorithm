n = int(input())

for i in range(1, n+1):
    nums = list(map(int, str(i)))
    if sum(nums)+i == n:
        print(i)
        break
else:
    print(0)