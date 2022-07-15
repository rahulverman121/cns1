def play_hangman():
    name = input("What is your name? ")
    print(f"Hello {name}, Time to play hangman!")
    print("Start guessing...")
    print("HINT: word is the name of a fruit\n")
    # here we set the secret word
    word = "apple"
    # creates an variable with an empty value
    guesses = ""
    # determine the number of turns
    turns = len(word) + 2

    # Create a while loop
    # check if the turns are more than zero
    while turns > 0:
        # make a counter that starts with zero
        failed = 0
        # for every character in secret_word
        for char in word:
            # see if the character is in the players guess
            if char in guesses:
                # print then out the character
                print(char)
            else:
                # if not found, print a dash
                print("_")
                # and increase the failed counter with one
                failed += 1

        # if failed is equal to zero
        # print You Won
        if failed == 0:
            print("You won the game :-)")
            # exit the script
            break

        # ask the user go guess a character
        guess = input("Guess a character: ")
        # set the players guess to guesses
        guesses += guess
        # if the guess is not found in the secret word
        if guess not in word:
            # turns counter decreases with 1
            turns -= 1
            # print wrong
            print("Wrong guess")
            # how many turns are left
            print(f"You have {turns} more guesses")

        # if the turns are equal to zero
        if turns == 0:
            # print "You Loose"
            print("You lost the game :-(")

if __name__ == "__main__":
    play_hangman()
