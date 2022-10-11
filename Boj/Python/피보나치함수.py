#Baekjoon 1003
import sys
input = sys.stdin.readline

arr = [[0, 0]] * 41
arr[0] = [1, 0]
arr[1] = [0, 1]

def fibonacci(n):
    global arr
    
    for i in range(2, 41):
        arr[i] = [arr[i-1][j]+arr[i-2][j] for j in range(2)]
    return arr[n]

n = int(input())
for _ in range(n):
    num = int(input())
    answer = fibonacci(num)
    print(answer[0], answer[1])