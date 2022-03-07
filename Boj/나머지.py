answer = set()
for i in range(10):
    num = int(input())
    answer.add(num%42)

print(len(answer))