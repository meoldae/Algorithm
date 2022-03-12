n = int(input())
nums = list(map(int, input().split()))
answer = dict()
for i in nums:
    answer[i] = 1

m = int(input())
my_nums = list(map(int, input().split()))

for i in my_nums:
    if i in answer:
        print(1)
    else:
        print(0)