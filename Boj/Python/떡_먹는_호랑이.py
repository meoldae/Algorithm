#Baekjoon 2502
import sys
input = sys.stdin.readline

def tteok(day, first, second):
    global k
    day -= 3
    while day:
        
        next = first + second   
        
        first = second
        second = next
        
        day -= 1
    
    if first + second == k:
        return True
    
    return False
    

if __name__ == '__main__':
    d, k = map(int, input().split())

    first = 1
    second = 2

    while True:                
        if tteok(d, first, second):
            print(first)
            print(second)
            exit()
        else:
            second += 1
            if second > k:
                first += 1
                second = first + 1