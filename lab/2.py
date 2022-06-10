import random


def gameWin(comp, you):
    if comp == you:
        return None
    if comp == "r":
        if you == "s":
            return False
        elif you == "p":
            return True
    if comp == "p":
        if you == "r":
            return True
        elif you == "s":
            return False
    if comp == "s":
        if you == "r":
            return True
        elif you == "p":
            return False


ch = "y"
while(ch == "y"):
    randNO = random.randint(1, 3)
    if randNO == 1:
        comp = "r"
    elif randNO == 2:
        comp = "p"
    elif randNO == 3:
        comp = "s"
    you = input("your Turn:  Rock(r) Paper(p) or Scissors(s)?")

    print("The computer chose : ", comp)
    a = gameWin(comp, you)
    if a == None:
        print("The game is a Tie!")
    elif a == False:
        print("You Lost!")
    else:
        print("You Won!")

    ch = input("do you want to play again?(y/n)")
