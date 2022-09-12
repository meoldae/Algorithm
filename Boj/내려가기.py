#Baekjoon 2096
import sys
input = sys.stdin.readline

n = int(input())
board = []

for i in range(n):
    a, b, c = map(int, input().split())
    
    tmp_max = [0] * 3
    tmp_min = [0] * 3
    
    if i == 0:
        dp_max = [a, b, c]
        dp_min = [a, b, c]
        
    else:
        for j in range(3):
            # Max
            if j == 0:
                tmp_max[j] = max(a+dp_max[j], a+dp_max[j+1])
                tmp_min[j] = min(a+dp_min[j], a+dp_min[j+1])
                
            elif j == 1:
                tmp_max[j] = max(b+dp_max[j-1], b+dp_max[j], b+dp_max[j+1])
                tmp_min[j] = min(b+dp_min[j-1], b+dp_min[j], b+dp_min[j+1])
                
            elif j == 2:
                tmp_max[j] = max(c+dp_max[j-1], c+dp_max[j])
                tmp_min[j] = min(c+dp_min[j-1], c+dp_min[j])
        
        for k in range(3):
            dp_max[k] = tmp_max[k]            
            dp_min[k] = tmp_min[k]
    
print(max(dp_max), min(dp_min))