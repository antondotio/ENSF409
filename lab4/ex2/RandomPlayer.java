public class RandomPlayer extends Player {

    public RandomPlayer(String name, char mark){
        super(name, mark);
    }

    @Override
    protected void play(){
        while(true){
            System.out.println("RandomPlayer " + name +" will now make a move");
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
        RandomGenerator random = new RandomGenerator();
        boolean finishedTurn = false;
        while(!finishedTurn) {
            int row = random.discrete(0, 2);
            int col = random.discrete(0, 2);
            if (board.getMark(row, col) == SPACE_CHAR) {
                board.addMark(row, col, mark);
                finishedTurn = true;
            }
        }
    }
}
