
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/** 
 * Provides data fields and methods to create a tic-tac-toe game 
 * in a Java application
 *
 * @author Antonio Santos
 * @version 2.0
 * @since March 25, 2019
*/
public class Game implements Constants, Runnable {
	/**
	 * The board that will be used in the game
	 */
	private Board theBoard;
	/**
	 * The moderator that will be in charge of watching the game
	 */
	private Referee theRef;
	/**
	 * Creates a new Board object to play on
	 */
    public Game(PrintWriter aSocketOut, PrintWriter bSocketOut) {
    	theBoard  = new Board(aSocketOut, bSocketOut);
	}
	
	/**
	 * Sets the referee and tells it to start the game
	 * @param r	sets the referee that will be running the game
	 * @throws IOException
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
		theRef.setBoard(theBoard);
		theRef.getxPlayer().setBoard(theBoard);
		theRef.getoPlayer().setBoard(theBoard);
    }

	/**
	 * Tells the referee to begin the game
	 */
	@Override
    public void run(){
    	try {
			theRef.runTheGame();
		}catch (Exception e){
    		e.printStackTrace();
		}
	}
}
