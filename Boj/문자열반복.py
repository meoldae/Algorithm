n = int(input())

for i in range(n):
    n, str = input().split()
    for j in str:
        print(j*int(n), end='')
    print()