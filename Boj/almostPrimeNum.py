a, b = map(int, input().split())

answer = 0

for i in range(a, b):
    if i**0.5 == int(i**0.5) and i != 1:                   # 제곱수 판별 i == N^2 ?
        temp = int(i**0.5)                      # temp = N
        for j in range(2, int(temp**0.5)+1):    # 소수 판별 
            if (temp) % j == 0:
                break
        else:
            n = 2
            while temp <= b/temp:
                if temp ** n > b:
                    break
                else:
                    n += 1
                    answer += 1

print(answer)
