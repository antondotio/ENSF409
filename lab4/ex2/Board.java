

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**
 * This class is in charge of displaying the board on the console
 * and adding the marks that the players put on the board.
 * It will also be in charge of checking for a winner or if the 
 * board is full. 
 * 
 * @author Antonio Santos
 * @version 1.0
 * @since January 31, 2019
 */
public class Board implements Constants {
	/**
	 * The board that will be displayed on the console
	 */
	private char theBoard[][];
	/**
	 * the number of marks on the board
	 */
	private int markCount;

	/**
	 * creates the the board matrix.
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

	public Board(Board b){
		this.markCount = b.markCount;
		this.theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			this.theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				this.theBoard[i][j] = b.theBoard[i][j];
		}
	}

	/**
	 * Returns the mark placed in the wanted element 
	 * @param row	index of row
	 * @param col	index of column
	 * @return	the character within the wanted element
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * checks if the board is full
	 * @return	the markCount = to 9;
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * will constantly check the board to see if xPlayer has won the game
	 * @return returns whether the player has won or not
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * will constantly check the board to see if xPlayer has won the game
	 * @return returns whether the player has won or not
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * displays the board on the console.
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
	 * Sets the element with the mark given by the player and 
	 * increases the mark count
	 * @param row	index of row
	 * @param col	index of col
	 * @param mark	mark that will be placed in the element
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * clears the board and resets the mark count
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * checks if a player has won the game
	 * @param mark	the mark that will be used to check for winner
	 * @return returns result. will return 1 if there is a winner else 0
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
	 * displays the column header
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * displays the hyphens 
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	/**
	 * adds white space 
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}

	public int getMarkCount(){
		return  markCount;
	}

}
