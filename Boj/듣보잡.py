# Baekjoon 1764
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

no_hear = set()
no_see = set()

for _ in range(n):
    no_hear.add(input().rstrip())
    
for _ in range(m):
    no_see.add(input().rstrip())
    
no_see_hear = no_hear & no_see

print(len(no_see_hear))
no_see_hear = list(no_see_hear)
no_see_hear.sort()

for man in no_see_hear:
    print(man)