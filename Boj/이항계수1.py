import math
def solution():
    n, k = map(int, input().split())

    if 0 <= k and k <= n:
        print(math.factorial(n) // (math.factorial(k) * math.factorial(n-k)))
        return
    elif k < 0:
        print(0)
        return
    elif k > n:
        print(0)
        return

solution()