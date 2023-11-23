package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		// Move the character on the map according to the entered string
		switch (input) {
			case "up":
				moveUp(character, gameMap);
				break;
			case "down":
				moveDown(character, gameMap);
				break;
			case "left":
				moveLeft(character, gameMap);
				break;
			case "right":
				moveRight(character, gameMap);
				break;
			default:
				System.out.println("Use only keywords up, down, left, right");
				break;
		}

	}


	private static void moveRight(GameCharacter character, Map gameMap) {
		// Gets the number of columns for the current role
		int sizeX = character.column;
		// Gets the number of lines for the current role
		int sizeY = character.row;
		// Check whether the number of columns of the current role is smaller than the number of columns on the map
		if (sizeX + 1 < gameMap.layout[0].length) {
			// Check whether the position to the right of the current role is empty
			if (gameMap.layout[sizeY][sizeX + 1] != ".") {
				// Check whether the position to the right of the current role is %
				if (gameMap.layout[sizeY][sizeX] == "%") {
					// Check whether the position on the right of the current role is *
					if (gameMap.layout[sizeY][sizeX + 1] == "*") {
						character.hurtCharacter(gameMap.characters[0]);
					}else {
						System.out.println("Monster already there so can't move");
					}
				}else {
					// Traverse all characters in the map
					for (int i = 1; i < gameMap.characters.length; i++) {
						// Determine whether the position to the right of the current character is the same as the position of the character on the map
						if (gameMap.characters[i].row == sizeY && gameMap.characters[i].column == sizeX + 1) {
							// Damage the current character
							character.hurtCharacter(gameMap.characters[i]);
							// Check whether the current role's health is less than or equal to 0
							if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
								// Set the position of the current role to x
								gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
							}
							break;
						}
					}
				}
			} else {
				// Set the left position of the current role to the right position
				gameMap.layout[sizeY][sizeX + 1] = gameMap.layout[sizeY][sizeX];
				// Set the left position of the current role to empty
				gameMap.layout[sizeY][sizeX] = ".";
				// Set the number of columns for the current role to the right
				character.setColumn(sizeX + 1);
			}
		} else {
			System.out.println("You can't go right. You lose a move.");
		}
	}

	private static void moveLeft(GameCharacter character, Map gameMap) {
		int sizeX = character.column;
		int sizeY = character.row;
		if (sizeX - 1 >= 0){
			if (gameMap.layout[sizeY][sizeX - 1] != ".") {
				if (gameMap.layout[sizeY][sizeX] == "%") {
					if (gameMap.layout[sizeY][sizeX - 1] == "*") {
						character.hurtCharacter(gameMap.characters[0]);
					}else {
						System.out.println("Monster already there so can't move");
					}
				} else {
					for (int i = 1; i < gameMap.characters.length; i++) {
						if (gameMap.characters[i].row == sizeY && gameMap.characters[i].column == sizeX - 1) {
							character.hurtCharacter(gameMap.characters[i]);
							if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
								gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
							}
							break;
						}
					}
				}
			} else {
				gameMap.layout[sizeY][sizeX - 1] = gameMap.layout[sizeY][sizeX];
				gameMap.layout[sizeY][sizeX] = ".";
				character.setColumn(sizeX - 1);
			}
		} else {
			System.out.println("You can't go left. You lose a move.");
		}
	}

	private static void moveUp(GameCharacter character, Map gameMap) {
		int sizeX = character.column;
		int sizeY = character.row;
		if (sizeY - 1 >= 0) {
			if (gameMap.layout[sizeY - 1][sizeX] != ".") {
				if (gameMap.layout[sizeY][sizeX] == "%") {
					if (gameMap.layout[sizeY - 1][sizeX] == "*") {
						character.hurtCharacter(gameMap.characters[0]);
					}else {
						System.out.println("Monster already there so can't move");
					}
				} else {
					for (int i = 1; i < gameMap.characters.length; i++) {
						if  (gameMap.characters[i].row == sizeY - 1 && gameMap.characters[i].column == sizeX) {
							character.hurtCharacter(gameMap.characters[i]);
							if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
								gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
							}
							break;
						}
					}
				}
			} else {
				gameMap.layout[sizeY - 1][sizeX] = gameMap.layout[sizeY][sizeX];
				gameMap.layout[sizeY][sizeX] = ".";
				character.setRow(sizeY - 1);
			}
		} else {
			System.out.println("You can't go up. You lose a move.");
		}
	}

	private static void moveDown(GameCharacter character, Map gameMap) {
		int sizeX = character.column;
		int sizeY = character.row;
		if (sizeY + 1 < gameMap.layout.length) {
			if (gameMap.layout[sizeY + 1][sizeX] != ".") {
				if (gameMap.layout[sizeY][sizeX] == "%") {
					if (gameMap.layout[sizeY + 1][sizeX] == "*") {
						character.hurtCharacter(gameMap.characters[0]);
					}else {
						System.out.println("Monster already there so can't move");
					}
				} else {
					for (int i = 1; i < gameMap.characters.length; i++) {
						if (gameMap.characters[i].row == sizeY + 1 && gameMap.characters[i].column == sizeX) {
							character.hurtCharacter(gameMap.characters[i]);
							if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
								gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
							}
							break;
						}
					}
				}
			} else {
				gameMap.layout[sizeY + 1][sizeX] = gameMap.layout[sizeY][sizeX];
				gameMap.layout[sizeY][sizeX] = ".";
				character.setRow(sizeY + 1);
			}
		} else {
			System.out.println("You can't go down. You lose a move.");
		}
	}


	
}
