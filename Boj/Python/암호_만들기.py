#Baekjoon 1759
import sys
import copy
input = sys.stdin.readline

def dfs(crypto, i, coll, cons):
    global alphabet, l, c
    
    if len(crypto) >= l: 
        if coll >= 1 and cons >= 2:
            print(''.join(crypto))
        else:
            return
    else:
        for idx in range(i, c):
            nextCrypto = copy.deepcopy(crypto)
            nextCrypto.append(alphabet[idx])
            if alphabet[idx] in ['a', 'e', 'i', 'o', 'u']:
                dfs(nextCrypto, idx+1, coll+1, cons)
            else:
                dfs(nextCrypto, idx+1, coll, cons+1)
    return

if __name__ == '__main__':
    l, c = map(int, input().split())
    alphabet = list(sorted(list(input().rstrip().split())))
    
    for i in range(c):
        lst = [alphabet[i]]
        if alphabet[i] in ['a', 'e', 'i', 'o', 'u']:
            dfs(lst, i+1, 1, 0)
        else:
            dfs(lst, i+1, 0, 1)