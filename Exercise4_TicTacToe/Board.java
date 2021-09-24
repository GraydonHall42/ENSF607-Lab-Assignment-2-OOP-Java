package Exercise4_TicTacToe;

/**
 * Provides data fields and methods to createa a Java data-type, representing a tic-tac-goe board in a Java application.
 * The purpose of this class is to give players a tic-tac-toe board to interact with, in order to play the game.
 * @author Graydon Hall and Mohammad Moshirpour
 * @since 2021-09-21
 */
public class Board implements Constants {

	/**
	 * Character array used to hold values for the tic-tac-toe board
	 */
	private char theBoard[][];

	/**
	 * Gives a count of marks on the board
	 */
	private int markCount;

	/**
	 * Consructs the board object, setting the original markCount to 0, and creating theBoard array
	 * as a 3x3 empty char array.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Returns the mark on the board at a specified row and column
	 * @param row the row of interest
	 * @param col the column of interest
	 * @return the value at this row and column
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Tells whether the board is full or not
	 * @return true if the board is full
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks whether player X has won the game
	 * @return True if X wins the game
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks whether player Y has won the game
	 * @return True if Y wins the game
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the tic-tac-toe board in the terminal
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds mark to the tic-tac-toe board after verifying the spot is not taken
	 * @param row row to add mark at
	 * @param col column to add mark at
	 * @param mark mark to add (either X or Y)
	 * @return True if the mark was successfully added
	 */
	public boolean addMark(int row, int col, char mark) {
		if(!Character.isLetter(theBoard[row][col])){
			theBoard[row][col] = mark;
			markCount++;
			return true;
		}
		else {
			System.out.println("Invalid entry: this location is taken. Try again!\n");
			return false;
		}
	}

	/**
	 * Clears the tic-tac-toe board
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks whether the game has been won
	 * @param mark The mark to check for 3 in a row of
	 * @return 1 if 3 in a row mark is identified.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Prints column headers for board to terminal
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Prints hyphens to board for the purpose of formatting the boards row edtes
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Used to add spaces and | marks onto the board for the purposes of formatting the
	 * tic-tac-toe boxes column edges
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
