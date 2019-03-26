import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * The server in this program and will be
 * in charge of setting the players
 * the referee and the game. The starting
 * point of the program.
 *
 * @author Antonio Santos
 * @version 1.0
 * @since March 25, 2019
 */
public class Server {
    /**
     * Server socket to connect the server
     * and the client
     */
    private ServerSocket serverSocket;
    /**
     * socket for xPlayer client
     */
    private Socket aSocket;
    /**
     * socket for oPlayer client
     */
    private Socket bSocket;
    /**
     * For executing the game and allowing
     * more than one client to connect to server
     */
    private ExecutorService pool;
    /**
     * For output to terminal of xPlayer
     */
    private PrintWriter aSocketOut;
    /**
     * For output to terminal of oPlayer
     */
    private PrintWriter bSocketOut;

    /**
     * Server class constructor
     * Sets the server and executor server.
     * @param portNumber port number to connect to
     */
    public Server(int portNumber){
        try{
            serverSocket = new ServerSocket(portNumber);
            pool = Executors.newCachedThreadPool();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Sets the players, referee and game.
     * Begins the game.
     * @throws IOException
     */
    public void communicateWithClient() throws IOException{
        try {
            while(true) {
                aSocket = serverSocket.accept();
                bSocket = serverSocket.accept();
                aSocketOut = new PrintWriter((aSocket.getOutputStream()), true);
                bSocketOut = new PrintWriter((bSocket.getOutputStream()), true);

                Player xPlayer = new Player(aSocket, 'X');

                Player oPlayer = new Player(bSocket, 'O');
                System.out.println("Both players connected");

                Referee theRef = new Referee();

                theRef.setoPlayer(oPlayer);
                theRef.setxPlayer(xPlayer);

                Game theGame = new Game(aSocketOut, bSocketOut);
                System.out.println("Creating a game!");
                theGame.appointReferee(theRef);

                System.out.println("Started a game!");

                pool.execute(theGame);

            }
        }catch (Exception e){
            e.printStackTrace();
            pool.shutdown();
        }

    }

    public static void main(String[] args)throws IOException{
        Server server = new Server(9788);
        System.out.println("Server is now running.");
        server.communicateWithClient();
    }

}
