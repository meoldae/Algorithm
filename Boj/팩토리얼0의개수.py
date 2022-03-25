import math
n = int(input())
temp = str(math.factorial(n))
count = 0

for i in temp[::-1]:
    if i != '0':
         print(count)
         break
    count += 1