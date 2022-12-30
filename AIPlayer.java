public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name)
    {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        int move = board.AImoveMaker(symbol);
        System.out.println(name + "(AI), please enter your move (1-7): " + move);
    }

}