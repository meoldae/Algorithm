import sys
input = sys.stdin.readline

n, c = map(int, input().split())
houses = []
for i in range(n):
    houses.append(int(input()))
houses.sort()

left = 1
right = houses[-1] - houses[0]
distance = 0

if c == 2:
    print(right)
    
else:
    while(left < right):
        mid = (left + right)//2
        count = 1
        current_house = houses[0]
        for house in houses:
            if house - current_house >= mid:
                count +=1
                current_house = house
        if count >= c:
            distance = mid
            left = mid + 1
        elif count < c:
            right = mid
    print(distance)