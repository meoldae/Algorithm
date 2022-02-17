n = int(input())

count = 0

for i in range(1, n+1):
    temp = str(i)
    if len(temp) <= 2:
        count += 1
        
    else:
        gap = int(temp[1]) - int(temp[0])
        for j in range(len(temp)-1):
            if gap != int(temp[j+1]) - int(temp[j]):
                break
        else:
            count += 1
print(count)            