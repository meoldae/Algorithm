#Baekjoon 2212
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
sensors = list(map(int, input().split()))

if n <= k:
    print(0)
else:
    sensors.sort()
    dist = []
    for i in range(n-1):
        dist.append(sensors[i+1]-sensors[i])

    dist.sort(reverse=True)

    while k-1 > 0:
        del dist[0]
        k -= 1

    print(sum(dist))