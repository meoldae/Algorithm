# Baekjoon 16916
import sys
input = sys.stdin.readline


def makeLPS(w):
    # lps = prefix, suffix 최대 일치 길이 
    # 접두사, 접미사가 일치했던 부분까지 돌아가서 검사 ( 같은 부분 스킵 )
    lps = [0]*len(w)

    # Prefix Suffix 구하기
    # left, right의 문자가 같으면 1씩 증가시키면서 진행
    # left, right 문자 같으면 left 하나 증가시키고 lps[right] = left, 그리고 right + 1 시킴
    # left, right 일치하지 않으면 left만 -1

    left = 0 
    for right in range(1, len(w)):
        while left > 0 and w[left] != w[right]:
            left = lps[left-1]
        if w[left] == w[right]:
            left += 1
            lps[right] = left
    
    return lps

def KMP(str, w, lps):
    L = len(str)
    l = len(w)
    left = 0
    for right in range(L):
        while(left > 0 and str[right] != w[left]):
            left = lps[left-1]
        if str[right] == w[left]:
            if left == l-1:
                return 1
            else:
                left += 1
    else:
        return 0 
    
if __name__ == '__main__':
    str = input().rstrip()
    w = input().rstrip()
    
    answer = KMP(str, w, makeLPS(w))
    print(answer)