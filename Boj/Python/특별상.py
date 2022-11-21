#Baekjoon 25391
import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())

students = []

for _ in range(n):
    scores = list(map(int, input().split()))
    students.append(scores)

students.sort(key = lambda x : x[1], reverse=True)
main = students[:k]
special = students[k::]
special.sort(key=lambda x:x[0], reverse=True)

answer = 0
for a, b in main:
    answer += a

for i in range(m):
    answer += special[i][0]

print(answer)