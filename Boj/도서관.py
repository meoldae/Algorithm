#Baekjoon 1461
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
books = list(map(int, input().split()))

neg_books = []
pos_books = []
flag = 0
for book in books:
    if book < 0:
        neg_books.append(book)
    elif book > 0:
        pos_books.append(book)
    if abs(flag) < abs(book):
        flag = book

pos_books.sort(reverse=True)
neg_books.sort()

answer = 0

for idx in range(0, len(pos_books), m):
    if pos_books[idx] != flag:
        answer += pos_books[idx]
    
for idx in range(0, len(neg_books), m):
    if neg_books[idx] != flag:
        answer += abs(neg_books[idx])

answer *= 2
answer += abs(flag)

print(answer)