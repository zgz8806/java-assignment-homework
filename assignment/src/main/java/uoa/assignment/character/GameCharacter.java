package uoa.assignment.character;

public abstract class GameCharacter {
	private String name;
	private int health;
	public int row;
	public int column;

	public GameCharacter(String name) {
		// Assigns the parameter name to the variable name
		this.name = name;
		// Assign the variable health to 100
		this.health = 100;
	}

	public abstract void hurtCharacter(GameCharacter character);

	public abstract boolean successfulDefense();

	// Define a method sayName that returns the value of the variable name
	public String sayName() {
		return name;
	}

	// Define a method getHealth that returns the value of the variable health
	public int getHealth() {
		return health;
	}

	// Define a method called setHealth, passing an integer parameter called health
	public void setHealth(int health) {
		this.health = health;
	}

	// Define two methods setRow and setColumn, passing in two integer arguments row and column
	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}


}

