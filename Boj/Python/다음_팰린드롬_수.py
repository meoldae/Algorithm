#Baekjoon 1334
import sys
input = sys.stdin.readline

n = input().rstrip()

next = n[0:len(n)//2]
next2 = ''.join(reversed(n[0:len(n)//2]))
print(next)
print(next2)


# def solution(n):
#     n = str(n)
#     for i in range(len(n)//2):
#         if n[i] != n[-(i+1)]:
#             return False
#     else:
#         return True

# while True:
#     if solution(n+1):
#         print(n)
#         break
#     else:
#         n += 1