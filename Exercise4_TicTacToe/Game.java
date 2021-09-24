package Exercise4_TicTacToe;

import java.io.*;

/**
 * Provides data fields and methods to createa a Java data-type, representing a tic-tac-goe board in a Java application.
 * The purpose of this class is to give players a tic-tac-toe board to interact with, in order to play the game.
 * @author Graydon Hall and Mohammad Moshirpour
 * @since 2021-09-21
 */
public class Game implements Constants {
	/**
	 * Tic-tac-toe board that the game interacts with.
	 */
	private Board theBoard;

	/**
	 * TicTacToeGame.Referee used to set up key parameters for the game, and objects that interact with it.
	 */
	private Referee theRef;

	/**
	 * Constructs the game object, instantiating a new board for the game to utilize.
	 */
    public Game( ) {
        theBoard  = new Board();
	}

	/**
	 * Appoints a referee for the game,
	 * @param r referee for the game
	 * @throws IOException
	 */
    public void appointReferee(Referee r){
        theRef = r;
    	theRef.runTheGame();
    }

	/**
	 * Main method used to initialize and run the game of tic-tac-toe
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));

		// get X player
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);

		// get O player
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);

		// create referee
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
