#Baekjoon 2447
import sys
input = sys.stdin.readline 

n = int(input())
'''
Stars = [["*"] * n for _ in range(n)]

def star(x, y, n):
    global Stars    
    if n == 3:
        Stars[x+1][y+1] = " "
        return
    
    N = n//3
    
    for i in range(x, x+n):
        for j in range(y, y+n):
            if(i-x)//N == 1 and (j-y)//N == 1:
                Stars[i][j] = " "
    
            else:
                if i % N == 0 and j % N == 0:
                    star(i, j, N)
    return

star(0, 0, n)            

for s in Stars:
    print("".join(s))
'''

def star(n):
    if n == 1:
        return ['*']
    
    recursion = star(n//3)
    Star = []
    
    for s in recursion:
        Star.append(s*3)
        
    for s in recursion:
        Star.append(s+" "*(n//3)+s)
    
    for s in recursion:
        Star.append(s*3)
    
    return Star

print('\n'.join(star(n)))