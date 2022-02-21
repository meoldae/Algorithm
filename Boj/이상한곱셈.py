a, b = input().split()

a = list(map(int, list(a)))
b = list(map(int, list(b)))

answer = 0

for i in range(len(b)):
    answer += sum(a)*b[i]
    
print(answer)



    
