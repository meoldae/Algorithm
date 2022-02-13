a, b = map(int, input().split())

cnt = 1

while True:
    cnt += 1
    temp = b
    
    if b%10 == 1:
        b //= 10
    elif b%2 == 0:
        b //= 2
    
    if temp == b and a != b:
        print(-1)
        break
    
    if a == b:
        print(cnt)
        break