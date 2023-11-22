package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {
	public Monster(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			character.setHealth(character.getHealth() - 20);
		}
	}

	public boolean successfulDefense() {
		Random random = new Random();
		return random.nextBoolean();
	}



	public String decideMove() {
		Random random = new Random();
		int move = random.nextInt(4);
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
