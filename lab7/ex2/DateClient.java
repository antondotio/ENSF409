import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The client in this simple Client-Server application.
 * The purpose of this application is to receive
 * either the current date or current time depending on
 * what the user asks for
 * @author Antonio Santos
 * @version 1.0
 * @since March 25, 2019
 */
public class DateClient {
    /**
     * The socket to set up the connection
     * between client and server
     */
    private Socket aSocket;
    /**
     * For writing to the server
     */
    private PrintWriter socketOut;
    /**
     * For reading from the keyboard
     */
    private BufferedReader stdIn;
    /**
     * For receiving the inputs from the server
     */
    private BufferedReader socketIn;

    /**
     * The constructor for the client class
     * and sets the class variables.
     * @param serverName  the server name
     * @param portNumber  the port number
     */
    public DateClient(String serverName, int portNumber){
        try{
            System.out.println(serverName + portNumber);
            aSocket = new Socket(serverName, portNumber);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            socketOut = new PrintWriter((aSocket.getOutputStream()), true);
        }catch (IOException e){
            System.err.println("Problem with constructor" + e.getStackTrace());
        }
    }

    /**
     * Starts the program.
     */
    public void communicate(){
        String line = "";
        String response = "";
        while(!line.equals("QUIT")){
            try{
                System.out.println("Please enter your choice (DATE/TIME): ");
                line = stdIn.readLine();
                socketOut.println(line);
                response = socketIn.readLine();
                System.out.println(response);
            }catch (IOException e){
                System.err.println("Sending error: " + e.getMessage());
            }catch (Exception e){
                System.err.println("Something is wrong " + e.getMessage());
                break;
            }
        }
        try {
            stdIn.close();
            socketIn.close();
            socketOut.close();
        } catch (IOException e) {
            System.out.println("Closing error: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        DateClient myClient = new DateClient("localhost", 9090);
        myClient.communicate();
    }
}
