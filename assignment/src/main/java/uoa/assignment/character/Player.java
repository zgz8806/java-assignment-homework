package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter {
	public Player(String name) {
		super(name);
	}

	public void hurtCharacter(GameCharacter character) {
		// Check whether the defense is successful
		if (!character.successfulDefense()) {
			if (character.getHealth() <= 0) {
				System.out.println("Character already dead");
			}else {
				character.setHealth(character.getHealth() - 50);
			}
		}
	}

	public boolean successfulDefense() {
		Random random = new Random();
		// Return a random number between 0 and 1
		return random.nextDouble() <= 0.3;
	}

}