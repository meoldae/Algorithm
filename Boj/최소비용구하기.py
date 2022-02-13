import sys

def get_smallest_node():
    min_value = 100000
    idx = 0
    for j in range(n):
        if distance[i] < min_value and visited[i] == 0:
            min_value = distance[i]
            idx = i
    return idx

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

bus = [[] for i in range(n)]
visited = [0] * (n)
distance = [100000 for i in range(n)]

for i in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    bus[a-1].append((b-1, c))

start, end = map(int, sys.stdin.readline().split())
start -= 1
end -= 1

distance[start] = 0
visited[start] = 1

for i in bus[start]:
    distance[i[0]] = i[1]
    
for i in range(n-1):
    now = get_smallest_node()
    visited[now] = 1
    
    for j in bus[now]:
        cost = distance[now] + j[1]
        
        if cost < distance[j[0]]:
            distance[j[0]] = cost

print(distance[end])