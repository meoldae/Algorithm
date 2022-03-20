import sys
input = sys.stdin.readline

n = int(input())

people = []
for i in range(n):
    age, name = input().split()
    age = int(age)
    people.append((age, name))
    
people.sort(key = lambda x:x[0])

for age, name in people:
    print(str(age)+" "+name)