import sys
input = sys.stdin.readline

n = int(input())

people = []
for i in range(n):
    weight, height = map(int, input().split())
    people.append((weight, height))
    
for w, h in people:
    count = 1
    for w_2, h_2 in people:
        if w_2 > w and h_2 > h:
            count += 1
    print(count, end=" ")