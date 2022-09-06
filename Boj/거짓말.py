#Baekjoon 1043
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

truth = list(map(int, input().split()))
truth = set(truth[1::])

parties = []
for _ in range(m):
    parties.append(set(list(map(int, input().split()))[1::]))

for _ in range(m):
    for party in parties:
        if party.intersection(truth):
            truth = truth|party

answer = 0
for party in parties:
    if not party.intersection(truth):
        answer += 1

print(answer)