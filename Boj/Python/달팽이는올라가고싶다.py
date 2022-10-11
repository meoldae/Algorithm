a, b, v = map(int, input().split())
a -= b
v -= b
if v % a == 0:
    print(v//a)
else:
    print(v//a+1)