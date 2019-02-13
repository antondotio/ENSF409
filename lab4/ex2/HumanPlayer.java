import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, char mark){
        super(name, mark);
    }

    @Override
    protected void play(){
        while(true){
            makeMove();
            if(board.xWins() == true){
                board.display();
                System.out.println("GAME OVER: " + name + " is the winner.");
                break;
            }else if(board.oWins() == true){
                board.display();
                System.out.println("GAME OVER: " + name + " is the winner.");
                break;
            }else if(board.isFull() == true){
                board.display();
                System.out.println("GAME OVER: game ended in a tie");
                break;
            }
            board.display();
            opponent.play();
        }
        System.out.println("Game ended...");
        System.exit(1);
    }

    @Override
    protected void makeMove(){
        System.out.print("\n" + name + ", what row would you like your next " + mark + " be placed in?");
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        System.out.print("\n" + name + ", what column would you like your next " + mark + " be placed in?");
        int col = scan.nextInt();
        if(board.getMark(row, col) == LETTER_O || board.getMark(row, col) == LETTER_X){
            System.out.println("\nSpot already taken, please choose an open space.");
            makeMove();
        }
        board.addMark(row, col, mark);

    }

}
