import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {
    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader stdIn;
    private BufferedReader socketIn;

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
