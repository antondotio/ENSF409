import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class takes care of all of the information about the player
 * and also where the game moves are executed.
 * 
 * @author Antonio Santos
 * @version 2.0
 * @since March 25, 2019
 */
public class Player implements Constants{
    /**
     * name of the player
     */
    private String name;
    /**
     * the game board that will be used in the game
     */
    private Board board;
    /**
     * the opponent of the current player
     */
    private Player opponent;
    /**
     * the mark of the player
     */
    private char mark;
    /**
     * For receiving inputs from client
     */
    private BufferedReader socketIn;
    /**
     * For writing to the client
     */
    private PrintWriter socketOut;

    /**
     * Player constructor sets the name and mark
     * @param aSocket socket for player to use
     * @param mark mark to be used by the player
     */
    public Player(Socket aSocket, char mark){
        this.mark = mark;

        try{
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter(aSocket.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Sends a string to be printed to terminal of client
     * @param toSend string to be sent
     */
    private void sendString(String toSend){
        socketOut.println(toSend);
        socketOut.flush();
    }

    /**
     * Gets the name of the player
     */
    public void getPlayerName(){
        try{
            sendString("Please enter the name of '" + mark + "' player: \0");
            name = socketIn.readLine();
            while(name == null){
                sendString("Please try again. \0");
                name = socketIn.readLine();
            }
        }catch (IOException e){
            System.err.println("Error getting name...");
            e.printStackTrace();
        }
    }

    /**
     * Where the game starts. Prompts players to make moves and checks
     * every turn if a player has won.
     */
    public void play() throws IOException{
        while(true){
            makeMove();
            board.display();
            if(board.xWins() == true){
                board.printXWin();
                break;
            }else if(board.oWins() == true){
                board.printOWin();
                break;
            }else if(board.isFull() == true){
                board.printTie();
                break;
            }
            opponent.play();
        }
        System.out.println("Game ended...");
        board.exit();
        System.exit(1);
    }
    
    /**
     * Where the players make their moves.
     */
    public void makeMove() throws IOException{
        String regex = "[0-9]+";
        int row, col;
        String rStr, cStr;

        sendString("\n" + name + ", what row would you like your next " + mark + " be placed in?\0");
        rStr = socketIn.readLine();
        while(!rStr.matches(regex)){
            sendString("\n" + name + ", what row would you like your next " + mark + " be placed in?\0");
            rStr = socketIn.readLine();
        }
        row = Integer.parseInt(rStr);

        sendString("\n" + name + ", what column would you like your next " + mark + " be placed in?\0");
        cStr = socketIn.readLine();
        while(!cStr.matches(regex)){
            sendString("\n" + name + ", what column would you like your next " + mark + " be placed in?\0");
            cStr = socketIn.readLine();
        }
        col = Integer.parseInt(cStr);

        while(true){
            boolean acceptable = isAcceptable(row, col, rStr, cStr);
            if(acceptable == true) break;

            sendString("Please enter the row again: \0");
            rStr = socketIn.readLine();
            row = Integer.parseInt(rStr);
            sendString("Please enter the column again: \0");
            cStr = socketIn.readLine();
            col = Integer.parseInt(cStr);
        }

        board.addMark(row, col, mark);
    }

    /**
     * Checks whether the given row or column are valid.
     * @param row row to put the mark in
     * @param col column to put the mark in
     * @param rStr row input of user
     * @param cStr column input of user
     * @return a boolean of whether the input is acceptable or not
     */
    private boolean isAcceptable(int row, int col, String rStr, String cStr){
        boolean acceptable = true;
        if(rStr == null || cStr == null){
            acceptable = false;
            return acceptable;
        }
        if(row < 0 || row > 2 || col < 0 || col > 2){
            acceptable = false;
            return acceptable;
        }
        if(board.getMark(row, col) == LETTER_O || board.getMark(row, col) == LETTER_X){
            sendString("\nSpot already taken, please choose an open space.");
            acceptable = false;
            return acceptable;
        }
        return acceptable;
    }

    /**
     * sets the opponent of a player
     * @param player opponent of current player
     */
    public void setOpponent(Player player){
        opponent = player;
    }

    /**
     * sets board of the game
     * @param board board to be used by the game
     */
    public void setBoard(Board board){
        this.board = board;
    }
}