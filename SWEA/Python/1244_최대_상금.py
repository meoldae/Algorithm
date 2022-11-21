t = int(input())

def dfs(idx, count):
    global maxVal, num
    
    if count == 0:
        maxVal = max(maxVal, int(''.join(num)))
        return
    
    for i in range(idx, len(num)):    
        for j in range(i+1, len(num)):
            num[i], num[j] = num[j], num[i]
            dfs(i, count-1)
            num[i], num[j] = num[j], num[i]
        
    return

for tc in range(1, t+1):
    num, count = map(int, input().split())
    maxVal = -1
    num = list(str(num))
    
    dfs(0, count)
    print("#{} {}".format(tc, maxVal))