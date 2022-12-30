public class main {
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('A', board, "Alice"));
        // game.setPlayer2(new HumanPlayer('B', board, "INSERT NAME HERE")); This is the line for adding a second player, simply uncomment this, and comment the AIPlayer line to play local co-op
        game.setPlayer2(new AIPlayer('B', board, "Bob"));
        game.playGame();
    }
}
