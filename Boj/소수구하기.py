m, n = map(int, input().split())
if m == 1:
    m+= 1
for i in range(m, n+1):
    for j in range(2, int(i**0.5)+1):
        if i%j == 0:
            break
    else:
        print(i)