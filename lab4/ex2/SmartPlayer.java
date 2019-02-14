public class SmartPlayer extends BlockingPlayer {

    public SmartPlayer(String name, char mark){
        super(name, mark);
    }

    protected void makeMove(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(board.getMark(row, col) == SPACE_CHAR){
                    if(testForWinning(row, col)) {
                        board.addMark(row, col, mark);
                        return;
                    }
                }
            }
        }
        super.makeMove();
    }

    protected boolean testForWinning(int row, int col){
        Board b = new Board(board);
        b.addMark(row, col, mark);
        if(LETTER_X == mark && b.xWins())
            return true;
        else if(LETTER_O == mark && b.oWins())
            return true;
        else
            return false;
    }
}
