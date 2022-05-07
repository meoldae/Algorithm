import sys
input = sys.stdin.readline

count = 0

n = int(input())
x = 0+n

temp = list(map(int, str(n)))
print("x: ", x)
while True:
    count += 1

    c = sum(temp)
    if c < 0:
        c = (c*10)+int(temp[1])
        
    if c == x:
        print(count)    
        break
    
    else:
        temp = list(map(int, str(c)))
    
    
    