import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    k = int(input())
    n = int(input())
    
    people_count = [i for i in range(1, n+1)]
    
    for j in range(k):
        for a in range(1, n):
            people_count[a] += people_count[a-1]   
            
    print(people_count[n-1])