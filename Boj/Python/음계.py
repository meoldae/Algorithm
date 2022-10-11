asc = [i for i in range(1, 9)]
des = [i for i in range(8, 0, -1)]

input = list(map(int, input().split()))

if input == asc:
    print('ascending')
elif input == des:
    print('descending')
else:
    print('mixed')