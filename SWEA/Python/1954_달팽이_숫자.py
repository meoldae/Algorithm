t = int(input())

for i in range(1, t+1):
    l = int(input())
    
    snail = [[0]*l for _ in range(l)]
    
    dx = [0, 1, 0, -1] # 시계 방향 동 > 남 > 서 > 북
    dy = [1, 0, -1, 0]
    
    value = 1
    x, y = 0, 0 # 초기 위치
    d = 0       # 진행 방향 ( 초기 방향 : 동 )
    while value <= l**2:
        snail[x][y] = value
        
        nx = x + dx[d]
        ny = y + dy[d]
        
        if 0 <= nx < l and 0 <= ny < l and snail[nx][ny] == 0: # 벗어나지 않고, 이미 입력한 곳이 아니면
            x = nx
            y = ny
        
        else: # 벗어나거나, 이미 입력한곳이면 방향 전환
            d = (d+1) % 4
            x += dx[d]
            y += dy[d]
        
        value += 1
        
    print("#{}".format(i))
    for lst in snail:
        print(*lst)