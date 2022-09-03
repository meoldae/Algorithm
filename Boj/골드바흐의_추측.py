#Baekjoon 9020
import sys
input = sys.stdin.readline

def isPrime(num):
    for i in range(2, int((num**0.5))+1):
        if num % i == 0:
            return False
    else:
        return True

def solution():
    target = int(input())
    left, right = target//2, target//2
    
    while left > 0:
        if isPrime(left) and isPrime(right):
            print(left, right)
            return
        else:
            left -= 1
            right += 1
    return
if __name__ == '__main__':
    t = int(input())

    for _ in range(t):
        solution()