#Baekjoon 1774
import sys, heapq
input = sys.stdin.readline

n, m = map(int, input().split())

p = [i for i in range(n)]

h = []
loca = []
for _ in range(n):
    loca.append(list(map(int, input().split())))

def find(x):   
    
    if x == p[x]:
        return x;
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
    
    if x == y:
        return True
    else:
        return False

def getDistance(src, dst):
    return ((loca[src][0] - loca[dst][0])**2 + (loca[src][1] - loca[dst][1])**2) ** 0.5;

for i in range(n):
    for j in range(i+1, n):
        if i != j:
            heapq.heappush(h, (getDistance(i, j), i, j))        

for _ in range(m):
    a, b = map(int, input().split())
    heapq.heappush(h, (0, a-1, b-1))

answer = 0

while h:
    now = heapq.heappop(h)
    if not isSameParent(now[1], now[2]):
        union(now[1], now[2])
        answer += now[0]

print("%.2f" %answer)