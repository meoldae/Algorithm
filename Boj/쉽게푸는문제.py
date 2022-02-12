a, b = map(int, input().split())

sum = 0
count = 1
for i in range(1, b+1):
    for j in range(i):
        if count >= a and count <= b:
            sum += i
        count += 1
print(sum)