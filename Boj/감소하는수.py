from itertools import combinations

nums = [i for i in range(10)]
N = int(input()) 

answer = []
for i in range(1, 11):
    temp = list(map(list, combinations(nums, i)))
        
    for j in range(len(temp)):
        temp[j] = sorted(temp[j], reverse=True)
    
    for j in range(len(temp)):
        answer.append(int(''.join(map(str, temp[j]))))
    
answer.sort()

if N >= len(answer):
    print(-1)
else:
    print(answer[N])