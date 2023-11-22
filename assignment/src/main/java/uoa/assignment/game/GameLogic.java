package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
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
		int sizeX = character.column;
		int sizeY = character.row;
		if (sizeX + 1 < gameMap.layout[0].length) {
			if (gameMap.layout[sizeY][sizeX + 1] != ".") {
				if (gameMap.layout[sizeY][sizeX] == "%") {
					if (gameMap.layout[sizeY][sizeX + 1] == "*") {
						character.hurtCharacter(gameMap.characters[0]);
					}else {
						System.out.println("Monster already there so can't move");
					}
				}else {
					for (int i = 1; i < gameMap.characters.length; i++) {
						if (gameMap.characters[i].row == sizeY && gameMap.characters[i].column == sizeX + 1) {
							character.hurtCharacter(gameMap.characters[i]);
							if (gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] != "x" && gameMap.characters[i].getHealth() <= 0) {
								gameMap.layout[gameMap.characters[i].row][gameMap.characters[i].column] = "x";
							}
							break;
						}
					}
				}
			} else {
				gameMap.layout[sizeY][sizeX + 1] = gameMap.layout[sizeY][sizeX];
				gameMap.layout[sizeY][sizeX] = ".";
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
