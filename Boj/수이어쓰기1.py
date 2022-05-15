n = input()
answer = 0

for i in range(len(n)-1):
    answer += 9 * (10**i) * (i+1)
    
answer += ((int(n) - (10 ** (len(n)-1)))+1) * len(n)

print(answer)