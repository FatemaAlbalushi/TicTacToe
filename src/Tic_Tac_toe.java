import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

///*
// * This program is used to open TicTacToe game where two player with two different symbol can play.
// */



public class Tic_Tac_toe {

//	/**
//	 * The main is for game start so the player 1 can make the first 
//   *  move then check availability and the winner then  it is player two turn
//	 */
	public static void main(String[] args) {

		char[][] arr = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

		Scanner input = new Scanner(System.in);
		boolean player1 = true; // player 1 move if its false it mean player 2 turn
		boolean gamestart = true;
		int count = 0;
		int row;
		int col;
		
		// The user went to resume the game
		boolean gameStarted = GameEnded("data/saveState.csv");
	        if (!gameStarted) {
	        	LastGame("data/saveState.csv",  arr, 1, 'X', 'O');
	        }
		
		System.out.println("Wellcome to Tic-Tac-Toe Program");
		// Starting of the Game
		while (gamestart) {

			if (count >= 9) {
				gamestart = false;
				System.err.println("draw");
			} else {
				gamestart = true;
			}

			Display(arr); // show the board
			// play one move
			if (player1) {
				System.out.println("player 1 Make a move, Enter a position: ");
				System.out.println("Enter E if you went to Exit the Game or N if not: ");
			    String exit = input.next();
			    // if the user enter E to exit the game the state will be stored in a file
			    //so the player will be able to resum the game
			    while (exit=="E") {
			    	 saveState("data/saveState.csv",arr, 1, 'X', 'O');
				}
			   
			    
				System.out.println("-------------------");
				int position = input.nextInt();

				if (position <= 3) // first row 1 2 3
				{
					row = 0;
					col = position - 1;
					//////////// move it to else and vs
					if (arr[row][col] == 'X' || arr[row][col] == 'O') {
						System.out.println("position not available");
						player1 = true;

					} else {
						/////////// variable instead of x o
						arr[row][col] = 'X';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') {
								System.out.println("Player with symbol X win");
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'X' && arr[1][j] == 'X' && arr[2][j] == 'X') {
								System.out.println("Player with symbol X win");
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
							System.out.println("Player with symbol X win");
							gamestart = false;

						}
						if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
							System.out.println("Player with symbol X win");
							gamestart = false;
						}

					}

				} else if (position <= 6) // second row 4 5 6
				{
					row = 1;
					col = position - 4;

					if (arr[row][col] == 'X' || arr[row][col] == 'O') {
						System.out.println("position not available");
						player1 = true;
					} else {
						arr[row][col] = 'X';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') {
								System.out.println("Player with symbol X win");
								Display(arr);
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'X' && arr[1][j] == 'X' && arr[2][j] == 'X') {
								System.out.println("Player with symbol X win");
								Display(arr);
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
							System.out.println("Player with symbol X win");
							Display(arr);
							gamestart = false;

						}
						if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
							System.out.println("Player with symbol X win");
							Display(arr);
							gamestart = false;
						}

					}

				} else if (position <= 9) // third row 7 8 9
				{
					row = 2;
					col = position - 7;

					if (arr[row][col] == 'X' || arr[row][col] == 'O') {
						System.out.println("position not available");
						player1 = true;
					} else {
						arr[row][col] = 'X';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') {
								System.out.println("Player with symbol X win");
								Display(arr);
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'X' && arr[1][j] == 'X' && arr[2][j] == 'X') {
								System.out.println("Player with symbol X win");
								Display(arr);
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
							System.out.println("Player with symbol X win");
							Display(arr);
							gamestart = false;

						}
						if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
							System.out.println("Player with symbol X win");
							Display(arr);
							gamestart = false;
						}

					}

				}

				System.out.println();
				count++;
				player1 = false;
			}
			// play two move
			else {
				System.out.println("player 2 Make a move, Enter a position: ");
				System.out.println("Enter E if you went to Exit the Game or N if not: ");
			    String exit= input.next();
			    // if the user enter E to exit the game the state will be stored in a file
			    //so the player will be able to resum the game
			    while (exit=="E") {
			    	 saveState("data/saveState.csv",arr, 1, 'X', 'O');
				}
			   
				System.out.println("-------------------");
				int position = input.nextInt();
				if (position <= 3) // first row 1 2 3
				{
					row = 0;
					col = position - 1;

					if (arr[row][col] == 'X' || arr[row][col] == 'O') {
						System.out.println("position not available");
						player1 = false;
					} else {
						arr[row][col] = 'O';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'O' && arr[1][j] == 'O' && arr[2][j] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;

						}
						if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;
						}

					}

				} else if (position <= 6) // second row 4 5 6
				{
					row = 1;
					col = position - 4;

					if (arr[row][col] == 'O' || arr[row][col] == 'X') {
						System.out.println("position not available");
						player1 = false;
					} else {
						arr[row][col] = 'O';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'O' && arr[1][j] == 'O' && arr[2][j] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;

						}
						if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;
						}

					}

				} else if (position <= 9)// third row 7 8 9
				{
					row = 2;
					col = position - 7;

					if (arr[row][col] == 'X' || arr[row][col] == 'O') {
						System.out.println("position not available");
						player1 = false;
					} else {
						arr[row][col] = 'O';

						// check the winner
						// check the row
						for (int i = 0; i <= 2; i++) {
							if (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check by col
						for (int j = 0; j <= 2; j++) {
							if (arr[0][j] == 'O' && arr[1][j] == 'O' && arr[2][j] == 'O') {
								System.out.println("Player with symbol O win");
								Display(arr);
								gamestart = false;
							}

						}
						// check Diagonal
						if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;

						}
						if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
							System.out.println("Player with symbol O win");
							Display(arr);
							gamestart = false;
						}

					}

				}
				player1 = true;
				count++;

			}

		}

	}

	// This method to Display the board
	public static void Display(char[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
				System.out.print("|" + " ");
			}

			System.out.println();
			System.out.println("-----------");

		}
	}

	// method to check the winner
	public static char Iswin(char[][] arr, char symbol) {
		// check for rows
		for (int i = 0; i <= 2; i++) {
			if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] == symbol) {
				return symbol;
			}

		}
		// check for rows
		for (int j = 0; j <= 2; j++) {
			if (arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j] && arr[0][j] == symbol) {
				return symbol;
			}

		}
		if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] == symbol) {

			return symbol;
		}
		if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] == symbol) {

			return symbol;
		}
		return 0;

	}
	
	/**
	 * this method to save the player input so they can then resume the game.
	 * @param filepath
	 * @param arr
	 * @param player : the player 1 or player 2
	 * @param Symbol1 : the symbol of player 1
	 * @param Sympol2 : the symbol of player 2
	 */
	public static void saveState(String filepath, char[][] arr, int player, char Symbol1, char Sympol2) {
        // TODO Auto-generated method stub
        try {
        	
            FileWriter gameState = new FileWriter(filepath);
            gameState.write(player + "\n");
            gameState.write(Symbol1 + "\n");
            gameState.write(Sympol2 + "\n");
            for(int row = 0; row < arr.length; ++row) {
                for(int col = 0; col < arr[0].length; ++col) {
                    gameState.write(arr[row][col] + "\n");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	/**
	 * this method to chech the gmae state if the game endes.
	 * @param filepath
	 * @return
	 */
	private static boolean GameEnded(String filepath) {
        // TODO Auto-generated method stub
        File gameState = new File(filepath);
        
        if (gameState.exists()) {
            return true;
        } else {
            return false;
        }
        
        
        
        
    }
	
	
	/**
	 * method to load the last game so the player can resum the game.
	 * @param filepath
	 * @param arr : the game board
	 * @param player : the player 1 or 2
	 * @param Symbol1 : the symbol of player 1
	 * @param Symbol2 : the symbol of player 2
	 */
	
	private static void LastGame(String filepath, char[][] arr, int player, char Symbol1, char Symbol2) {
        // TODO Auto-generated method stub
        File gameState = new File(filepath);
        
        try {
            Scanner stateScanner = new Scanner(gameState);
            player = Integer.parseInt(stateScanner.nextLine());
            Symbol1 = stateScanner.nextLine().charAt(0);
            Symbol2 = stateScanner.nextLine().charAt(0);
            
            for(int row = 0; row < arr.length; ++row) {
                for(int col = 0; col < arr[0].length; ++col) {
                    arr[row][col] = stateScanner.nextLine().charAt(0);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	
	

	
}
