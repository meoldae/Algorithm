import sys

while True:
    n = sys.stdin.readline().rstrip()
    if int(n) == 0:
        break
    temp = len(n)+1
    for i in n:
        if int(i) == 0:
            temp += 4
        elif int(i) == 1:
            temp += 2
        else:
            temp += 3
    print(temp)
