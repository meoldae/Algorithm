a, b = map(int, input().split())

cnt = 1

while True:
    cnt += 1
    
    temp = b
    print(temp)
    if b%2 == 0:
        b //= 2
    elif b%10 == 1:
        b //= 10
    
    if temp == b and a != b:
        print(-1)
        break
    
    if a == b:
        print(cnt)
        break
    
    