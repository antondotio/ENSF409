import java.io.IOException;

/**
 * This class will be in charge of setting the board and setting the players.
 * 
 * @author Antonio Santos
 * @version 2.0
 * @since March 25, 2019
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
    public void runTheGame() throws IOException {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        xPlayer.getPlayerName();
        oPlayer.getPlayerName();

        System.out.println("\nReferee has started the game");
        board.display();
        xPlayer.play();
        System.out.println("\nReferee has ended the game");
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

    /**
     * gets the player that will use the X mark
     * @return the player that will use the X mark
     */
    public Player getxPlayer() {
        return xPlayer;
    }

    /**
     * gets the player that will use the O mark
     * @return the player that will use the O mark
     */
    public Player getoPlayer() {
        return oPlayer;
    }
}