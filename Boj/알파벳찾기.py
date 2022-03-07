str = input()

for i in range(97, 123):
    if chr(i) in str:
        print(str.index(chr(i)), end=' ')
    else:
        print(-1, end=' ')