import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class will be the server in this simple Client-Server
 * application. This application will check whether an input
 * string is a palindrome or not.
 * It will handle the checking of the palindromes.
 *
 * @author Antonio Santos
 * @version 1.0
 * @since March 25, 2019
 */
public class Server {
    /**
     * The server socket
     */
    ServerSocket serverSocket;
    /**
     * socket to connect server and client
     */
    Socket aSocket;
    /**
     * For sending outputs to client
     */
    PrintWriter out;
    /**
     * For receiving input from the client
     */
    BufferedReader in;

    /**
     * Constructor for the server class. Sets the server socket to
     * connect to the same port as the client.
     */
    public Server(){
        try{
            serverSocket = new ServerSocket(8099);
        }catch (IOException e){
            System.err.println("Could not listen on port: 8099");
            System.exit(1);
        }
        System.out.println("Server is running");
    }

    /**
     * Starts the server
     */
    public void startApp(){
        String line = null;
        while(true){
            try{
                line = in.readLine();
                checkPalindrome(line);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * checks whether the string is a palindrome or not and
     * gives the result back to the client
     * @param s string to be checked
     */
    public void checkPalindrome(String s){
        int front = 0;
        int back = s.length() - 1;
        while(front < back){
            char frontChar = s.charAt(front++);
            char backChar = s.charAt(back--);
            if(frontChar != backChar){
                out.println(s + " is not a palindrome.");
                return;
            }
        }
        out.println(s + " is a palindrome");
    }

    public static void main(String[] args){
        Server myServer = new Server();
        try{
            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Accepted");
            myServer.in = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.out = new PrintWriter((myServer.aSocket.getOutputStream()), true);

            myServer.startApp();

            myServer.in.close();
            myServer.out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
