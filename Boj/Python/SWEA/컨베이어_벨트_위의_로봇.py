#Baekjoon 20055
#삼성 SW 역량테스트 기출 문제
import sys
input = sys.stdin.readline

def solution():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    robot = []
    round = 1
    
    while True:
        # 1. 로봇과 벨트 회전
        a.insert(0, a.pop())
        robot = list(map(lambda x:x+1, robot))
        if len(robot) >= 1 and robot[0] >= n-1:
            del robot[0]
        
        # 2. 로봇 한 칸씩 이동
        forDel = []
        for r in range(len(robot)):
            if a[robot[r]+1] > 0 and robot[r]+1 not in robot:
                robot[r] += 1
                a[robot[r]] -= 1
                if robot[r] >= n-1:
                    forDel.append(r)
        for d in forDel:
            del robot[d]

        # 3. 로봇 올리는 위치에 올림
        if a[0] > 0 and robot.count(0) == 0:
            a[0] -= 1
            robot.append(0)
        
        # 4. 내구도 0의 갯수가 K개 이상이면 종료
        if a.count(0) >= k:
            return round
        
        round +=1 

if __name__ == '__main__':
    print(solution())