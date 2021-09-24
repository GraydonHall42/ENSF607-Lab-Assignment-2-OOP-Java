package TicTacToeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Provides data fields and methods to create a Java data type, representing a player in a game of
 * Tic-Tac Toe.
 *
 * @author Graydon Hall
 * @since 2021-09-21
 */
public class Player {

    /**
     * The name of the player
     */
    private String name;

    /**
     * The board the player interacts with and plays tic tac toe on
     */
    private Board board;

    /**
     * The players opponent in the game of tic-tac-toe
     */
    private Player opponent;

    /**
     * The players mark they place on the board, either an X or an O.
     */
    private char mark;

    /**
     * Constructs ther person object, and assigns their name as well as the mark they will play the game with
     * as either X or O.
     * @param name The players name
     * @param letter The letter they will play the game with, either X or O.
     */
    public Player(String name, char letter) {
        this.name = name;
        this.mark = letter;
    }

    /**
     * Checks that the game has not been completed, proceeds to call the makeMove() method so the player can
     * place an X or an O, and then checks once more to see if the game has been completed.
     */
    public void play(){
        if(!gameIsOver()){  // check game isn't over
            try {
                makeMove();  // make a move
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!gameIsOver()){  // continue if game is not over
            opponent.play();
        }
    };

    /**
     * Prompts the player for a location on the board to place either an X or an O.
     * @throws IOException if an I/O error occurs
     */
    public void makeMove() throws IOException {
        boolean validTurn = false;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        do {
            int row=-1;
            int col=-1;

            while (row < 0) {
                System.out.print("\n" + this.name + ", what row should your next " + this.mark + " be placed in? ");
                row = validateUserInput(stdin.readLine());
            }

            while (col < 0) {
                System.out.print(this.name + ", what column should your next " + this.mark + " be placed in? ");
                col = validateUserInput(stdin.readLine());
            }

            validTurn = board.addMark(row, col, mark);
        } while(!validTurn);
        board.display();
    }

    /**
     * Validates that the user enters a valid input for the tic-tac-toe game, i.e. an integer between 0 and 2.
     * Returns -1 if the input is invalid.
     * @param userInput user Input as a string.
     * @return integer value of the userInput
     */
    private int validateUserInput(String userInput) {
        String errorMessage = "Invalid input, please enter an integer between 0 and 2";
        int integerInput = -1;
        try{
            integerInput = Integer.parseInt(userInput);
        }catch (Exception e){
            System.out.println(errorMessage);
            return -1;
        }
        if(integerInput<0 || integerInput >2){
            System.out.println(errorMessage);
            return -1;
        }
        return integerInput;
    }

    /**
     * Performs check of whether or not the game is over
     * @return boolean True if the game is over.
     */
    private boolean gameIsOver(){
        if(board.isFull()){
            System.out.println("Tie game!");
            return true;
        } else if(board.oWins()){
            if (mark=='O'){
                System.out.println(name + " is the winner!");
            } else {
                System.out.println(opponent.getName() + "is the winner!");
            }
            return true;
        } else if(board.xWins()){
            if (mark=='X'){
                System.out.println(name + " is the winner!");
            } else {
                System.out.println(opponent.getName() + "is the winner!");
            }
            return true;
        } else{
            return false;
        }
    }

    /**
     * Sets the opponent for the player
     * @param opponent player that this player is facing in tic-tac-toe
     */
    public void setOpponent(Player opponent){
        this.opponent = opponent;
    };

    /**
     * the board which the player interacts with to play tic-tac-toe
     * @param theBoard
     */
    public void setBoard(Board theBoard){
        this.board = theBoard;
    };

    /**
     * Returns the name of the player
     * @return String the ame of the player
     */
    public String getName() {
        return name;
    }



}
