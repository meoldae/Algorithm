t = int(input())

for i in range(1, t+1):
    
    n = int(input())
    price = list(map(int, input().split()))
    
    maxVal = price[-1]
    count = 0
    answer = 0
    for j in range(len(price)-2, -1, -1):
        if price[j] < maxVal:
            count += 1
            answer -= price[j]
        
        else:
            answer += (maxVal*count)
            count = 0
            maxVal = price[j]
    
    answer += (maxVal*count)
    
    print("#{} {}".format(i, answer))