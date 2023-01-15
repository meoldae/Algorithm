#Baekjoon 14889
#삼성 SW 역량테스트 기출 문제
from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())

ability = []
members = [i for i in range(n)]

for _ in range(n):
    ability.append(list(map(int, input().split())))
    
c = list(combinations(members, n//2))

answer = 1e9
for link in c:
    start = [member for member in members if member not in link]
    
    start_ability = 0
    link_ability = 0
    
    for i in range((n//2)-1):
        for j in range(i+1, n//2):
            start_ability += (ability[start[i]][start[j]] + ability[start[j]][start[i]])
            
    for i in range((n//2)-1):
        for j in range(i+1, n//2):
            link_ability += (ability[link[i]][link[j]] + ability[link[j]][link[i]])
    
    answer = min(answer, abs(start_ability-link_ability))

print(answer)