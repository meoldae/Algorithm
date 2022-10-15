#Baekjoon 2877
k = int(input())
dst = bin(k+1)

for i in range(3, len(dst)):
    if dst[i] == '1':
        print('7',end="")
    else:
        print('4',end="")