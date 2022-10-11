#Baekjoon 15686
import sys
from itertools import combinations
input = sys.stdin.readline

def chicken_distance(chicken, house):
    answer = 1e9
    for i in range(len(chicken)):    # 선택된 치킨집 가지 수 
        total = 0
        for loc in house:
            distance = []
            for j in range(len(chicken[i])):
                distance.append(abs(loc[0]-chicken[i][j][0]) + abs(loc[1]-chicken[i][j][1]))
            total += min(distance)

        answer = min(answer, total)
    print(answer)
    return 

n, m = map(int, input().split())

houses = []
goobne = []

for i in range(1, n+1):
    temp = list(map(int, input().rstrip().split()))
    
    for j in range(n):
        if temp[j] == 1:
            houses.append([i, j+1])
        elif temp[j] == 2:
            goobne.append([i, j+1])

selectedChickens = list(combinations(goobne, m))

chicken_distance(selectedChickens, houses)