#Baekjoon 2023
import sys
input = sys.stdin.readline

def isPrime(num):
    for i in range(2, int(num**0.5)+1):
        if num % i == 0:
            return False
    return True

def dfs(num):
    global n
    if len(str(num)) == n:
        print(num)
        return
    else:       
        for i in range(10):
            nextNum = num*10 + i
            if isPrime(nextNum):
                dfs(nextNum)
    return

if __name__ == '__main__':
    n = int(input())
    
    for i in [2, 3, 5, 7]:
        dfs(i)