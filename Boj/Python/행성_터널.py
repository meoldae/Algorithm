#Baekjoon 2887
import sys, heapq
input = sys.stdin.readline

n = int(input())
p = [i for i in range(n)]

def find(x):
    if p[x] == x:
        return x
    else:
        p[x] = find(p[x])
        return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        if x < y:
            p[y] = x
        else:
            p[x] = y
    return

def isSameParent(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        return False
    
    return True

def getDistance(a, b):
    return min(abs(planet[a][0] - planet[b][0]), abs(planet[a][1] - planet[b][1]), abs(planet[a][2] - planet[b][2]))
    
planet = [] 
h = []

for _ in range(n):
    planet.append(list(map(int, input().split())))

for i in range(n-1):
    for j in range(i+1, n):
        heapq.heappush(h, (getDistance(i, j), i, j))




answer = 0
count = 0
while h:
    now = heapq.heappop(h)
    print(now)
    if not isSameParent(now[1], now[2]):
        answer += now[0]
        count += 1
        union(now[1], now[2])
        if count >= n-1:
            break
print(answer)
