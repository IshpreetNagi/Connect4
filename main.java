public class main {
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('A', board, "Alice"));
        game.setPlayer2(new AIPlayer('B', board, "Bob"));
        game.playGame();
    }
}
