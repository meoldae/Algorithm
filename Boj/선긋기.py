import sys
input = sys.stdin.readline

n = int(input())
lines = []
for i in range(n):    
    lines.append(list(map(int, input().split())))
lines.sort()

start = lines[0][0]
end = lines[0][1]
answer = 0
for line in lines:
    c_start, c_end = line[0], line[1]
    
    if end > c_start:
        end = max(end, c_end)
    
    else:
        answer += end-start
        start, end = c_start, c_end
        
answer += end-start
print(answer)