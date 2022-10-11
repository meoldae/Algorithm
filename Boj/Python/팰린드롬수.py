while True:
    temp = input()
    if temp == "0":
        break
    
    if temp == temp[::-1]:
        print('yes')
    else:
        print('no')