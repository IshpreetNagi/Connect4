import java.util.Scanner;

public class HumanPlayer extends Player {
    
    public HumanPlayer(char symbol, Board board, String name)
    {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) 
    {
        while (true)
        {
            Scanner input = new Scanner(System.in);
            System.out.println(name + ", please enter your move (1-7): ");
            try
            {
                int move = input.nextInt(); 
                if (move > 0 && move <= 7)
                {
                    move--;
                    boolean checker = board.moveMaker(move, symbol);
                    if (checker == true)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("***COLUMN FULL, PLEASE ENTER AGAIN***");
                    }
                }
                else
                {
                    System.out.println("***PLEASE ENTER A VALUE BETWEEN 1 AND 7***");
                }
            }
            catch (Exception e)
            {
                System.out.println("***PLEASE ENTER A VALID INPUT***");
            }
        }
    }
    
}