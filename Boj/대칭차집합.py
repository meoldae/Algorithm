#Baekjoon 1269
import sys
a, b = map(int, input().split())

a_s = set(map(int, input().split()))
b_s = set(map(int, input().split()))

print(len(a_s - b_s)+len(b_s - a_s))