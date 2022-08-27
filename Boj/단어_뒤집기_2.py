#Baekjoon 17413
import sys
input = sys.stdin.readline

s = input().rstrip()
flag = True

i = 0
while i < len(s):
    if s[i] == "<":
        while s[i] != ">":
            print(s[i], end="")
            i += 1
        else:
            print(">",end="")
            i += 1
    elif s[i] != " ":
        temp = ""
        while i < len(s) and s[i] != "<" and s[i] != " ":
            temp += s[i]
            i += 1
        print(temp[::-1], end="")

    else:
        print(" ",end="")
        i += 1