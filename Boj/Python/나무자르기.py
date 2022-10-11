import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

left = 0
right = max(trees)

def binary_search(left, right, m):
    while left <= right:
        mid = (left+right)//2

        length = 0
    
        for tree in trees:
            if tree > mid:
                length += (tree-mid)
    
        if length >= m:
            left = mid + 1
        else:
            right = mid - 1
    return right

print(binary_search(left, right, m))