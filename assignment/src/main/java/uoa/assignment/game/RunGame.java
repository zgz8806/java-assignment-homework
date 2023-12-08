package uoa.assignment.game;

import uoa.assignment.character.Monster;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		// Get the map height from the command line argument
		int height = Integer.parseInt(args[0]);
		// Get the map width from the command line argument
		int width = Integer.parseInt(args[1]);

		// Create a new Game object, passing in the height and width of the map
		Game game = new Game(height, width);

		// Initialize the number of turns
		int round = 1;

		while (!gameOver) {
			// Print the number of rounds to the console
			System.out.println("Round " + round);
			// Create a new Scanner object to receive user input
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			// Calls the game object's next turn method and updates the game end state based on the return value
			gameOver = game.nextRound(input);
			round++;

			// Print map layout
			//game.getMap().printLayout();

		}
	}

}
