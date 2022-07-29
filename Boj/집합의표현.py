#Baekjoon 1717
import sys
input = sys.stdin.readline

def find(x):
    if x == p[x]:
        return x
    else:
        p[x] = find(p[x])
        return p[x]

def union(x, y):
    x = find(x)
    y = find(y)
    
    if x != y:
        p[y] = x
    return

def isSameParent(x, y):
    x = find(x)
    y = find(y)
    
    if x == y:
        return True
    else:
        return False
    
n, m = map(int, input().split())
graph = [i for i in range(n+1)]
p = [i for i in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    
    if a == 0:
        if not isSameParent(b, c):
            if b < c:
                union(b, c)
            else:
                union(c, b)
    else:
       if isSameParent(b, c):
           print("YES")
       else:
           print("NO")