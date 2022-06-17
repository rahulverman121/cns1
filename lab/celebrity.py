def possible_celeb(people):
  possible = []  
  for i in range(0,len(people)):
    if len(people[i])==0:
      possible.append(i)
    print(possible)

  return possible
def find_celeb(people,possible):
  result = []
  for p in possible:
    celeb = False
    for r in range(0,len(people)):
      if r != p:
        for k in people[r]:
          if (ord(k) - 48) == p:
            celeb = True
            result.append(p)
  if len(result) == len(people) - 1:
    return result[0]
  else:
    return -1
num = int(input("ENTER NUMBER OF PEOPLE : "))
print("no  of people",num)

people = []
for i in range(num):
  people.append(input("ENTER PEOPLE KNOWN TO PERSON-{} : ".format(i)).split())
print(people)
possible = possible_celeb(people)
celeb = find_celeb(people,possible)
if celeb == -1:
  print("THERE IS NO CELEBRITY AMONG THESE PEOPLE")
else:
  print("THE PERSON IS THE CELEBRITY AMONG THESE PEOPLE: ", celeb)
