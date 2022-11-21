for i in range(1, 11):
    n = int(input())
    building = list(map(int, input().split()))
    answer = 0
    for j in range(2, n-2):
        left = building[j-2:j]
        right = building[j+1:j+3]
        height = max(max(left), max(right))
        if height < building[j]:
            answer += (building[j] - height)
    print("#{} {}".format(i, answer))