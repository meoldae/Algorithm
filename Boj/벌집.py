n = int(input())
num = 1
count = 1
while True:
    if num >= n:
        print(count)
        break
    
    num += count * 6
    count += 1