import sys
n = int(sys.stdin.readline()) + 1

zoo = [1] * n

if n >= 2:
    zoo[0] = 1
    zoo[1] = 3
    
    for i in range(2, n):
        zoo[i] = (zoo[i-1]*2)+zoo[i-2]
    
    print(zoo[-1]%9901)
    
elif n == 1:
    print(3)
else:
    print(1)