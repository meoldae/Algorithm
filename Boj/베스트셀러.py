import sys
input = sys.stdin.readline

n = int(input())

books = dict()

for i in range(n):
    title = input().rstrip()
    
    if title in books:
        books[title] = books[title]+1
    else:
        books[title] = 1
        

answer = [k for k, v in books.items() if max(books.values()) == v]

print(sorted(answer)[0])