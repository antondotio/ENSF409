import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The client in the program and will
 * handle the outputs to the terminal for
 * each player.
 *
 * @author Antonio Santos
 * @version 1.0
 * @since March 25, 2019
 */
public class Client {
    /**
     * For writing to other classes
     */
    private PrintWriter socketOut;
    /**
     * To connect the client to server
     */
    private Socket aSocket;
    /**
     * For reading inputs from the keyboard
     */
    private BufferedReader stdIn;
    /**
     * For reading inputs from other classes in the program
     */
    private BufferedReader socketIn;

    /**
     * Constructor for the client class
     * @param serverName the server name
     * @param portNumber the port number
     */
    public Client(String serverName, int portNumber){
        try{
            aSocket = new Socket(serverName, portNumber);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter((aSocket.getOutputStream()), true);
        } catch(IOException e){
            System.err.println("Error in Client!" + e.getStackTrace());
        }
    }

    /**
     * To connect with the server and handles the
     * outputs to the terminal and inputs from the
     * user and other classes in the program
     */
    public void communicateWithServer(){
        try{
            while(true){
                String read = "";

                while(true){
                    read = socketIn.readLine();
                    if(read.contains("\0")){
                        read = read.replace("\0", "");
                        System.out.println(read);
                        break;
                    }

                    if(read.equals("QUIT")){
                        return;
                    }
                    System.out.println(read);
                }

                read = stdIn.readLine();
                socketOut.println(read);
                socketOut.flush();
            }
        }catch (IOException e){
            System.err.println("Error in communicate...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client("localhost", 9788);
        client.communicateWithServer();
    }
}
