This is a mobile game with 2 mainActivies (login and game):

Login:
  *You have to enter your Name and Age, select if you are Male of Female (the button will be colored when you select one)
  *If you let a field empty, then it will appear a AlertDialog
  
Also I used SqlLite for the tabel with the words, and after login we will have our tabel and it will chose a random word

Game:
  *We have a image on the top, where the player will appear if she/he dones't chose a good letter:
    -if the player is ,,a man,, there will appear a man body
    -if the player is ,,a woman,, there will appear a woman body
  *A text field where we see how many tries we have
  *A text field where the word is, and the letter will appear if we chose the right ones
  *The keyboard:
    -if we click a button and the letter is in the word it will appear there and the button will dissapear
    -if we click a button and the letter isn't in the word it will appear a part of her/his body and the button will dissapear
  *Reset button: we can press it any time we want, it will restart the game, and will appear a new word
  *Win or Lose:
    -for both cases will appear a AlertDialog with a specific message, and you can press there ,,play again,, and will start a new game
    -for both cases, if we close the AlertDialog, you can press the keyboard but nothin will happen, because that game is over
    
