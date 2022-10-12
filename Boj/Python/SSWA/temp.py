n = 3
k = 2
a = [1, 2, 3, 4, 5, 6]
robot = [0, 1, 2, 3]
round = 1

for _ in range(6):
    print(a)
    a.insert(0, a.pop())

