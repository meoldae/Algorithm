#Baekjoon 1543
import sys
input = sys.stdin.readline

str = input().rstrip()
dst = input().rstrip()

str_2 = str.replace(dst, "A")

print(str_2.count("A"))