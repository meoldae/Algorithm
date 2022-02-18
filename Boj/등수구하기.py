# fail 
import sys
input = sys.stdin.readline

n, score, p = map(int, input().split())

if n == 0:
    print(1)
else:
    scores = list(map(int, input().split()))
    scores.sort(reverse=True)
    
    if n == p and scores[n-1] >= score:
        print(-1)
        
    else:
        for i in range(n):
            if scores[i] <= score:
                print(i+1)
        else:
            print(n+1)