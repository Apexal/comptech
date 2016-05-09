import java.util.Arrays;

public class Board {
	
	// These are both private so they can't be directly changed by the main class
	private int[][] board = new int[3][3];
	private boolean done = false;
	
	
	// 0 signifies not chosen yet
	// 1 is Player 1
	// 2 is Player 2
	public Board() {
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = 0;
			}
		}
	}
	
	private String getSpaceString(int spaceType) {
		String out = " ";
		
		switch(spaceType) {
			case 1:
				out = "X";
				break;
			case 2:
				out = "O";
				break;
		}
		
		return out;
	}
	
	public void show() {
		System.out.println("   1  2  3");
		System.out.printf("1 %s | %s | %s \n", getSpaceString(board[0][0]), getSpaceString(board[0][1]), getSpaceString(board[0][2]));
		System.out.println("  --|---|---");
		System.out.printf("2 %s | %s | %s\n", getSpaceString(board[1][0]), getSpaceString(board[1][1]), getSpaceString(board[1][2]));
		System.out.println("  --|---|---");
		System.out.printf("3 %s | %s | %s\n", getSpaceString(board[2][0]), getSpaceString(board[2][1]), getSpaceString(board[2][2]));
	}
	
	public void makeMove(int row, int column, int player) throws BoardSpaceException {
		try {
			if(board[row-1][column-1] != 0)
				throw new BoardSpaceException("Space already taken!");
			
			board[row-1][column-1] = player;
		} catch(Exception e) {throw new BoardSpaceException();}
	}
	
	public boolean done() {
		return done;
	}
	
	public int checkWin() {
		int[] win1 = {1, 1, 1};
		int[] win2 = {2, 2, 2};
		
		// Horizontal/vertical wins wins
		for(int i = 0; i < board.length; i++){
			int[] column = {board[0][i], board[1][i], board[2][i]};
			int[] row = board[i];
			
			if(Arrays.equals(row, win1) || Arrays.equals(row, win2)) {
				done = true;
				return row[0]; // Returns player who wins (can choose any number from the row)
			}
			
			if(Arrays.equals(column, win1) || Arrays.equals(column, win2)) {
				done = true;
				return column[0];
			}
		}
		
		// Diagonal wins
		int[] diag1 = {board[0][0], board[1][1], board[2][2]};
		int[] diag2 = {board[0][2], board[1][1], board[2][0]};
		if(Arrays.equals(diag1, win1) || Arrays.equals(diag1, win2)) {
			done = true;
			return diag1[0]; // Returns player who wins (can choose any number from the diagonal)
		}
		
		if(Arrays.equals(diag2, win1) || Arrays.equals(diag2, win2)) {
			done = true;
			return diag2[0];
		}
		
		return 0;
	}
} 
