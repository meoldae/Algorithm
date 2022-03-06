str = input().upper()
str_set = list(set(str))

answer = []
for word in str_set:
    temp = str.count(word)
    answer.append(temp)
    
if answer.count(max(answer)) > 1:
    print("?")
else:
    print(str_set[(answer.index(max(answer)))].upper())