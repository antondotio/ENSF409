
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in){ 
        // takes a sequence of integers as inputs, and outputs their sum

		int s, nextInt;
		s = 0;

		System.out.println("Please input the sequence of integers to sum, terminated by a 0");

		nextInt = readNum(in);

		//Read next datum in input. An integer is expected

		while (nextInt!=0) {
			s = s + nextInt;
			nextInt = readNum(in);
		}

		System.out.println("The sum is " + s);
    }

    public static int readNum(BufferedReader in){
    	int nextInt;
    	while(true){
    		try{
    			nextInt = Integer.parseInt(in.readLine());
			}catch (NumberFormatException nfe){
    			System.out.println("Invalid input value. Please input an integer number");
    			continue;
			}catch (IOException ioe){
    			System.out.println("Problem reading line. Please try again.");
    			continue;
			}
    		break;
		}
    	return nextInt;
	}

	public static String getLine(BufferedReader in){
    	String c;
    	while(true) {
			try {
				c = in.readLine();
			} catch (IOException ioe) {
				System.out.println("Problem reading line. Please try again.");
				continue;
			}
			break;
		}
		return c;
	}

    public static void main(String[] arg) {         

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
							 //"in" will receive data from the standard input stream
		String c;

		System.out.println("Do you wish to calculate a sum? (y/n)");
		c = getLine(in);

			 //Read next datum in input. A string "y" or "n" is expected

		while (!c.equals("y") && !c.equals("n")) {
			System.out.println("Please answer y or n");
			c = getLine(in);
		}

		while (c.equals("y")) {
			sum(in);
			System.out.println("Do you wish to calculate another sum? (y/n)");
			c = getLine(in);

			while (!c.equals("y") && !c.equals("n")) {
				System.out.println("Please answer y or n");
				c = getLine(in);
			}
		}

		System.out.println("Goodbye");
    }
}
