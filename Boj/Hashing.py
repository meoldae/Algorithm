# Baekjoon 15829
import sys
input = sys.stdin.readline

l = int(input())
str = input()
hash = 0
for i in range(l):
    hash += ((ord(str[i])-96)*(31**i)) 
print(hash%1234567891)