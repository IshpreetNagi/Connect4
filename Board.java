import java.util.Random;

public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private int c;

	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	
	public Board() 
	{
		char[][] assign = {	{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}	};
		this.board = assign;
	}
	
	public void printBoard() 
	{
		for (int i=0; i < board.length; i++)
		{
			char[] temp = board[i];
			for (int p=0; p < temp.length; p++)
			{
				System.out.print("|" + temp[p]);
			}
			System.out.print("|\n");
		}
	}

	public boolean moveMaker(int move, char symbol)
	{
		for (int i=5; i>=0; i--)
		{
			if (board[i][move] == ' ')
			{
				board[i][move] = symbol;
				return true;
			}
		}
		return false;
	}

	public boolean moveChecker(int move, char symbol)
	{
		for (c=5; c>=0; c--)
		{
			if (board[c][move] == ' ')
			{
				board[c][move] = symbol;
				return true;
			}
		}
		return false;
	}

	public int AImoveMaker(char symbol)
	{
		char unknown = ' ';
		
		// Checking if the AI can make a winning move
		for (int i=0; i<NUM_OF_COLUMNS; i++)
		{
			boolean tester = moveChecker(i, symbol);
			if (tester == true)
			{
				if (containsWin())
				{
					return (i);
				}
				else
				{
					board[c][i] = ' ';
				}
			}
			else
			{
				continue;
			}
		}

		for (int i=0; i<NUM_OF_ROW; i++)
		{
			for (int p=0; p<NUM_OF_COLUMNS; p++)
			{
				if (board[i][p] != ' ' && board[i][p] != symbol)
				{
					unknown = board[i][p];
				}
			}
		}

		// Checking to see if the Human can make any winning moves 
		// and blocking them off
		if (unknown != ' ')
		{
			for (int i=0; i<NUM_OF_COLUMNS; i++)
			{
				boolean tester = moveChecker(i, unknown);
				if (tester == true)
				{
					if (containsWin())
					{
						board[c][i] = ' ';
						moveMaker(i, symbol);
						return (i);
					}
					else
					{
						board[c][i] = ' ';
					}
				}
				else
				{
					continue;
				}
			}
		}

		// Making a random move
		while (true)
		{
			Random rand = new Random();
			int randNum = rand.nextInt(1,8);
			randNum--;
			boolean breaker = moveMaker(randNum, symbol);
			if (breaker)
			{
				randNum++;
				return (randNum);
			}
		}
	}
	
	public boolean containsWin() 
	{
		int checker = 0;

		// Horizontal Checker
		for (int i=0; i<NUM_OF_ROW; i++)
		{
			checker = 0;
			for (int p=0; p<NUM_OF_COLUMNS; p++)
			{
				if (board[i][p] != ' ')
				{
					try 
					{
						if (board[i][p] == board[i][p+1])
						{
							checker++;
							if (checker == 3)
							{
								return true;
							}
						}
						else
						{
							checker = 0;
						}
					} 
					catch (Exception e) 
					{
						break;
					}
				}
			}
		}

		checker = 0;

		// Vertical Checker
		for (int i=0; i<NUM_OF_COLUMNS; i++)
		{
			checker = 0;
			for (int p=0;p<NUM_OF_ROW; p++)
			{
				if (board[p][i] != ' ')
				{
					try 
					{
						if (board[p][i] == board [p+1][i])
						{
							checker++;
							if (checker == 3)
							{
								return true;
							}
						}
						else
						{
							checker = 0;
						}
					}
					catch (Exception e) 
					{
						break;
					}
				}
			}
		}

		checker = 0;

		// Left-Diagonal Checker
		for (int i=0; i<NUM_OF_ROW; i++)
		{
			for (int p=0; p<NUM_OF_COLUMNS; p++)
			{
				if (board[i][p] != ' ')
				{
					try 
					{
						if (board[i][p] == board[i+1][p+1] && board[i][p] == board[i+2][p+2] && board[i][p] == board[i+3][p+3])
						{
							return true;
						}
					} 
					catch (Exception e) 
					{
						break;
					}
				}
			}
		}

		// Right-Diagonal Checker
		for (int i=0; i<NUM_OF_ROW; i++)
		{
			for (int p=0; p<NUM_OF_COLUMNS; p++)
			{
				if (board[i][p] != ' ')
				{
					try 
					{
						if (board[i][p] == board[i-1][p+1] && board[i][p] == board[i-2][p+2] && board[i][p] == board[i-3][p+3])
						{
							return true;
						}
					} 
					catch (Exception e) 
					{
						break;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isTie() 
	{
		for (int i=0; i<NUM_OF_ROW; i++)
		{
			if (board[1][i] == ' ')
			{
				return false;
			}
		}
		return true;
	}
	
	public void reset() 
	{
		char[][] clear = {	{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
							{' ', ' ', ' ', ' ', ' ', ' ', ' '}	};
		this.board = clear;
	}
	
}