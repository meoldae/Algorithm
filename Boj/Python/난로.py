#Baekjoon 15553
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

friends = []
diff = []
for i in range(n):
    friends.append(int(input()))
    if i >= 1:
        diff.append(friends[i]-(friends[i-1]+1))

answer = friends[-1] - friends[0]+1


diff.sort(reverse=True)
print(diff)

for fire in range(k-1):
    answer -= diff[fire]
print(answer)