import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Board board = new Board();
		
		System.out.print("Enter 2 player names: ");
		String[] players = {input.next(), input.next()};
		
		board.show();
		
		int turn = 1;
		while(!board.done() && turn <= 9) {
			int player = (turn % 2 == 0 ? 2 : 1);
			System.out.println("\n\nTurn " + turn + ": " + players[player - 1]);
			
			try {
				System.out.print("Enter row + colum: ");
				board.makeMove(input.nextInt(), input.nextInt(), player);
				
				board.show();
				board.checkWin();
				
				turn++;
			}catch(BoardSpaceException e) { 
				System.out.println(e.getMessage());
			}
		}
		
		int winnerNum = board.checkWin();
		
		String winner = (winnerNum == 0 ? "Nobody" : players[winnerNum - 1]);
		System.out.println("\nGame over! " + winner + " Wins!");
	}
}
