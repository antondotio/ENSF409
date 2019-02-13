
/**
 * This class will be in charge of setting the board and setting the players.
 * 
 * @author Antonio Santos
 * @version 1.0
 * @since January 31, 2019
 */
public class Referee{
    /**
     * Player that uses the X mark
     */
    private Player xPlayer;
    /**
     * Player that uses the O mark
     */
    private Player oPlayer;
    /**
     * The board that will be used in the game.
     */
    private Board board;
    
    /**
     * Constructor for referee
     */
    public Referee(){}

    /**
     * Begins the game and sets the players as opponents
     * of one another
     */
    public void runTheGame(){
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        board.display();
        xPlayer.play();
    }  

    /**
     * sets the game board
     * @param board the game board
     */
    public void setBoard(Board board){
        this.board = board;
    }
    /**
     * sets the player that will use the O mark
     * @param oPlayer Player that will use the O mark
     */
    public void setoPlayer(Player oPlayer){
        this.oPlayer = oPlayer;
    }
    /**
     * sets the player that will use the X mark
     * @param xPlayer Player that will use the X mark
     */
    public void setxPlayer(Player xPlayer){
        this.xPlayer = xPlayer;
    }
}