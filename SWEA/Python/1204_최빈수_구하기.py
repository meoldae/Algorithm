t = int(input())

for tc in range(1, t+1):
    n = int(input())
    students = list(map(int, input().split()))
    students.sort(reverse=True)
    
    mode = [0]*101
    maxVal = -1
    answer = 0
    
    for score in students:
        mode[score] += 1
        if maxVal < mode[score]:
            answer = score
            maxVal = mode[score]
            
    print("#{} {}".format(tc, answer))