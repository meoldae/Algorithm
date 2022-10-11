#Baekjoon 3036
import sys, math
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

for i in range(1, n):
    gcd = math.gcd(lst[0], lst[i])
    print("{0}/{1}".format(lst[0]//gcd, lst[i]//gcd))