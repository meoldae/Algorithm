a = int(input())
b = int(input())
c = int(input())

nums = str(a*b*c)

for i in range(10):
    print(nums.count(str(i)))