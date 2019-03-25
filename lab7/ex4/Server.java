import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Server {
    private ServerSocket serverSocket;
    private Socket aSocket;
    private Socket bSocket;
    private ExecutorService pool;
    private PrintWriter aSocketOut;
    private PrintWriter bSocketOut;

    public Server(int portNumber){
        try{
            serverSocket = new ServerSocket(portNumber);
            pool = Executors.newCachedThreadPool();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

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
