#Baekjoon 10825
import sys
input = sys.stdin.readline

n = int(input())

students = []
for _ in range(n):
    temp = list(input().rstrip().split())
    temp[1:] = list(map(int, temp[1:]))

    students.append(temp)

students.sort(key=lambda x:(-x[1], x[2], -x[3], x[0]))
for student in students:
    print(student[0])