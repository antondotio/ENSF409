import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket aSocket;
    PrintWriter out;
    BufferedReader in;

    public Server(){
        try{
            serverSocket = new ServerSocket(8099);
        }catch (IOException e){
            System.err.println("Could not listen on port: 8099");
            System.exit(1);
        }
        System.out.println("Server is running");
    }

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
