n = int(input())

for i in range(1, n+1):
    x = str(i)
    if '3' in x or '6' in x or '9' in x:
        for alphabet in x:
            if alphabet in ['3', '6', '9']:
                print('-', end="")
    else:
        print(x, end="")
        
    print(" ", end="")