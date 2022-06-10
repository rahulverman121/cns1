def eliminate_non_celebrity(matrix):
    possible_celeb = 0
    n = len(matrix)
    for p in range(1, n):
        if(matrix[possible_celeb][p] or not matrix[p][possible_celeb]):
            possible_celeb = p
    return possible_celeb


def check_if_celebrity(possible_celeb, matrix):
    for i in range(n):
        if matrix[possible_celeb][i] is True:
            return False
    for i in range(n):
        if matrix[i][possible_celeb] is False:
            if i != possible_celeb:
                return False
    return True


n = int(input("Enter the number of people:"))

m = [[False]*n for _ in range(n)]

for i in range(n):
    people = input(f'Enter the people known to {i} :').split()
    for p in people:
        p = int(p)
        m[i][p] = True

possible_celeb = eliminate_non_celebrity(m)

if check_if_celebrity(possible_celeb, m):
    print(f'{possible_celeb} is the celebrity')
else:
    print("There is no celebrity")
