package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {
	public Monster(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		// If defense fails, damage is done to the character
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 20);
		}
	}

	public boolean successfulDefense() {
		// Randomly generate a Boolean value
		Random random = new Random();
		return random.nextBoolean();
	}


	public String decideMove() {
		Random random = new Random();
		// Randomly generate an integer ranging from 0 to 3
		int move = random.nextInt(4);
		// Depending on the integer, return different movement directions
		switch (move) {
			case 0:
				return "up";
			case 1:
				return "down";
			case 2:
				return "left";
			case 3:
				return "right";
			default:
				return "up";
		}
	}
}