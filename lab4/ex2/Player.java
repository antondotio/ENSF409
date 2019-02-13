import java.util.Scanner;

/**
 * This class takes care of all of the information about the player
 * and also where the game moves are executed.
 * 
 * @author Antonio Santos
 * @version 1.0
 * @since January 31, 2019
 */
abstract public class Player implements Constants{
    /**
     * name of the player
     */
    protected String name;
    /**
     * the game board that will be used in the game
     */
    protected Board board;
    /**
     * the opponent of the current player
     */
    protected Player opponent;
    /**
     * the mark of the player
     */
    protected char mark;

    /**
     * Player constructor sets the name and mark
     * @param name name of the player
     * @param mark mark to be used by the player
     */
    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    /**
     * Where the game starts. Prompts players to make moves and checks
     * every turn if a player has won.
     */
    abstract protected void play();
    
    /**
     * Where the players make their moves.
     */
    abstract protected void makeMove();

    /**
     * sets the opponent of a player
     * @param player opponent of current player
     */
    protected void setOpponent(Player player){
        opponent = player;
    }

    /**
     * sets board of the game
     * @param board board to be used by the game
     */
    protected void setBoard(Board board){
        this.board = board;
    }
}