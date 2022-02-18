import sys
input = sys.stdin.readline

king, stone, n = input().split()

col = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']

king_loc = [col.index(king[0]), 8-int(king[1])]
stone_loc = [col.index(stone[0]), 8-int(stone[1])]

for i in range(n):
    temp = input()

    if temp == 'R':
        king_loc[1] += 1
        if king_loc == stone_loc:
            
            
    elif temp == 'L':
    
    elif temp == 'B':
    
    elif temp == 'T':
    
    elif temp == 'RT':
    
    elif temp == 'LT':
    
    elif temp == 'RB':
        
    elif temp == 'LB':
        

        

