n = int(input())

for i in range(n):
    results = input()
    score = 0
    count = 0
    for result in results:
        if result == 'O':
            count += 1
            score += count
        else:
            count = 0
    print(score)