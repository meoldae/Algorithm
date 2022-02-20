import sys
input = sys.stdin.readline

n = int(input())
players = list()
for i in range(n):
    temp = input()
    players.append(temp)    

p = dict()

for player in players:
    if player[0] in p:
        p[player[0]] += 1
    else:
        p[player[0]] = 1

check = True
answer = []
for i in p:
    if p[i] >= 5:
        check = False
        answer.append(i)

if check:
    print("PREDAJA")
else:
    answer.sort()
    print(''.join(answer))