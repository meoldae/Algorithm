t = int(input())

for i in range(1, t+1):
    nums = [2, 3, 5, 7, 11]
    
    n = int(input())
    print("#{0}".format(i), end=" ")
    for num in nums:
        coef = 0
        while n % num == 0:
            n //= num 
            coef += 1
        print(coef, end=" ")
    print()