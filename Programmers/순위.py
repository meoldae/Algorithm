import numpy as np

def solution(n, results):
    answer = 0
    
    board = [["0" for i in range(n)]for i in range(n)]    
    for result in results:
        board[result[0]-1][result[1]-1] = "W"
        board[result[1]-1][result[0]-1] = "F"
    
    print(np.array(board))        
    
    # j k  vs j i + i k
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if board[j][k] == "0":    # 결정 안되어있으면 ?
                    if board[j][i] == "W" and board[i][k] == "W":   # j 가 i 이김 / i 는 k 이김 = j 가 k도 이김
                        board[j][k] = "W"
                    elif board[j][i] == "F" and board[i][k] == "F": # j 가 i 한테 짐 / i 는 k 한테 짐= j 가 k 한테도 질 것
                        board[j][k] = "F"
    
    for i in range(n):
        if board[i].count("0") == 1:
            answer += 1

    return answer

if __name__ == '__main__':
    n = 5
    results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
    answer = solution(n, results)
    print(answer)
    